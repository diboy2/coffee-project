<template>
  <div class="column is-8">
    <div class="card">
        <div class="card-content">
            <div class="content">
                <div class="columns is-multiline">
                  <coffee-list-info-item-rating v-for="rating in ratings" :key="rating.id" v-bind:heading="rating.heading">
                  </coffee-list-info-item-rating>
                </div>
                <div class="level">
                  <div class="level-left">

                  </div>
                  <div class="level-right">
                    <div class="level-item">
                      <div class="field">
                        <input id="switchExample" type="checkbox" name="switchExample" class="switch" checked="checked">
                        <label for="switchExample">Rate</label>
                      </div>
                    </div>
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
  export default{
    components:{
      'coffee-list-info-item-description':CoffeeListInfoItemDescription,
      'coffee-list-info-item-rating': CoffeeListInfoItemRating
    },
    mounted(){
      bulmaSwitch.attach();
    },
    data(){
      return {
        ratings: [
          {
            id: 1,
            meaning: "aroma",
            heading: "Aroma",
            value: 0
          },
          {
            id: 2,
            meaning: "flavor",
            heading: "Flavor",
            value: 0
          },
          {
            id: 3,
            meaning: "aftertaste",
            heading: "Aftertaste",
            value: 0
          },
          {
            id: 4,
            meaning: "acidity",
            heading: "Acidity",
            value: 0
          },
          {
            id: 5,
            meaning: "sweetness",
            heading: "Sweetness",
            value: 0
          },
          {
            id: 6,
            meaning: "mouthfeel",
            heading: "MouthFeel",
            value: 0
          },
          {
            id: 7,
            meaning: "balance",
            heading: "Balance",
            value: 0
          },
          {
            id: 8,
            meaning: "clean_cup",
            heading: "Clean Cup",
            value: 0
          },
          {
            id: 9,
            meaning: "uniformity",
            heading: "Uniformity",
            value: 0
          },
          {
            id: 10,
            meaning: "overall",
            heading: "Overall",
            value: 0
          }]
      };
    }
  }
</script>
