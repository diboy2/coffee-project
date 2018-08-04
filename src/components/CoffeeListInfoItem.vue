<template>
  <div class="column is-8">
    <div class="card">
        <div class="card-content">
            <div class="content">
                <div class="level">
                  <div class="level-left">

                  </div>
                  <div class="level-right">
                    <dropdown v-bind:dropdownItems="dropdownItems" v-bind:currentlySelectedDropdownItemKey="currentlySelectedDropdownItemKey" @update="updateDropdownKey"> </dropdown>
                  </div>
                </div>
                <div class="columns is-multiline">
                  <coffee-list-info-item-rating v-for="(rating, index) in ratings" :key="rating.id" v-bind:index="index" v-bind:heading="rating.heading" v-bind:showSlider="showSlider" v-on:rating-change="onRatingChange">
                  </coffee-list-info-item-rating>
                </div>
                <div class="level" v-show="showSlider">
                  <div class="level-left">

                  </div>
                  <div class="level-right">
                    <a class="button is-primary" @click="saveRatings">Save Ratings</a>
                  </div>
                </div>
            </div>
        </div>  
        <div class="card-footer">
            <article class="media card-footer-item">
              <figure class="media-left">
                <p class="image is-64x64">
                  <img src="https://bulma.io/images/placeholders/128x128.png">
                </p>
              </figure>
              <div class="media-content">
                <div class="field">
                  <p class="control">
                    <textarea class="textarea" placeholder="Add a comment..."></textarea>
                  </p>
                </div>
                <div class="level">
                  <div class="level-left">

                  </div>
                  <div class="level-right">
                    <div class="level-item">
                      <a class="button is-info">Submit</a>
                    </div>
                  </div>
                </div>
              </div>
            </article>
        </div>
    </div>
  </div>

</template>
<script>
  import CoffeeListInfoItemDescription from  "./CoffeeListInfoItemDescription.vue";
  import CoffeeListInfoItemRating from "./CoffeeListInfoItemRating.vue";
  import bulmaSwitch from "bulma-switch";
  import Dropdown from "./Dropdown.vue";
   import {
    COFFEE_LIST_INFO_ITEM_DROPDOWN
  } from "../constants.js";
  export default{
    components:{
      'coffee-list-info-item-description':CoffeeListInfoItemDescription,
      'coffee-list-info-item-rating': CoffeeListInfoItemRating,
      'dropdown': Dropdown
    },
    props: {
      showSlider: Boolean,
      coffee: Object
    },
    mounted(){
      bulmaSwitch.attach();
    },
    data(){
      return {
        dropdownItems: COFFEE_LIST_INFO_ITEM_DROPDOWN,
        currentlySelectedDropdownItemKey: "AVERAGE_RATINGS",
        showSlider: false,
        ratings: [
          {
            id: 1,
            mean: "aroma",
            heading: "Aroma",
            value: 0
          },
          {
            id: 2,
            mean: "flavor",
            heading: "Flavor",
            value: 0
          },
          {
            id: 3,
            mean: "aftertaste",
            heading: "Aftertaste",
            value: 0
          },
          {
            id: 4,
            mean: "acidity",
            heading: "Acidity",
            value: 0
          },
          {
            id: 5,
            mean: "sweetness",
            heading: "Sweetness",
            value: 0
          },
          {
            id: 6,
            mean: "mouthfeel",
            heading: "MouthFeel",
            value: 0
          },
          {
            id: 7,
            mean: "balance",
            heading: "Balance",
            value: 0
          },
          {
            id: 8,
            mean: "clean_cup",
            heading: "Clean Cup",
            value: 0
          },
          {
            id: 9,
            mean: "uniformity",
            heading: "Uniformity",
            value: 0
          },
          {
            id: 10,
            mean: "overall",
            heading: "Overall",
            value: 0
          }]
      };
    },
    methods: {
      updateDropdownKey(key){
        this.currentlySelectedDropdownItemKey = key;
        if(this.currentlySelectedDropdownItemKey === "MY_RATINGS"){
          this.showSlider = true;
        }
        else{
          this.showSlider = false;
        }
      },
      onRatingChange(object){
        this.ratings[object.index].value = object.value;
      },
      saveRatings(){
        const mappedRatings = this.ratings.map((rating) => {
          return {
            mean: rating.mean,
            value: rating.value
          }
        });
        this.$store.dispatch("saveRatings", {
          blendId: this.coffee.blendId,
          ratings: mappedRatings
        });
      }
    },   
  }
</script>
