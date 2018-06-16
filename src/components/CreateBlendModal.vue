<template>
    <div class="modal" v-bind:class="{ 'is-active':showCreateBlendModal}">
      <div class="modal-background"></div>
      <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title">Create Blend </p>
          <button class="delete" aria-label="close"
           v-on:click="hideCreateBlendModal"></button>
        </header>

               <figure class="image is-3by2 ">
                <img src="https://bulma.io/images/placeholders/480x320.png">
              </figure>


        <section class="modal-card-body">
          <div class="tags" style="padding: 10px;">
            <span class="tag is-medium"><a href="#">One</a></span>
            <span class="tag is-medium"><a href="#">One</a></span>
            <span class="tag is-medium"><a href="#">One</a></span>
             <span class="tag is-medium"><a href="#">OnesOne</a></span>
            <span class="tag is-medium"><a href="#">One</a></span>
            <span class="tag is-medium"><a href="#">One</a></span>
            <span class="tag is-medium"><a href="#">One</a></span>
            <span class="tag is-medium"><a href="#">One</a></span>
          </div>
        </section>
        <footer class="modal-card-foot">
          <button class="button is-success">Save</button>
        </footer>
      </div>
    </div>
</template>

<script>
  import CoffeeListMediaItem from "./CoffeeListMediaItem.vue";
  import CoffeeListInfoItem from "./CoffeeListInfoItem.vue";
  import bulmaTagsInput from "bulma-tagsinput";
  import { mapState } from 'vuex';

export default {
    components:{
      'coffee-list-media-item': CoffeeListMediaItem,
      'coffee-list-info-item': CoffeeListInfoItem
    },
    mounted(){
      bulmaTagsInput.attach();
    },
    computed: mapState({
      showCreateBlendModal: state => state.showCreateBlendModal
    }),
    methods: {
      hideCreateBlendModal(){
        this.$store.dispatch("hideShowCreateBlendModal", false);
      }
    },
    data(){
      return {
      }
    }
};
</script>
