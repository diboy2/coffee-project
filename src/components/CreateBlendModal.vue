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

            <input class="input" type="tags" placeholder="Add Tag" value="Tag1,Tag2,Tag3">

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
  import { mapState } from 'vuex';

export default {
    components:{
      'coffee-list-media-item': CoffeeListMediaItem,
      'coffee-list-info-item': CoffeeListInfoItem
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
