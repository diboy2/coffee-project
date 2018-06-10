<template>
  <div class="container">
    <div class="columns" v-for="coffee in coffees" :key="coffee.id" >
      <coffee-list-media-item v-bind:coffee="coffee" ></coffee-list-media-item>
      <coffee-list-info-item></coffee-list-info-item>
    </div>
  </div>
</template>
<script>
  import axios from "axios";
  import CoffeeListMediaItem from "./CoffeeListMediaItem.vue";
  import CoffeeListInfoItem from "./CoffeeListInfoItem.vue";
  import { mapState } from 'vuex';

  export default{
    components: {
      'coffee-list-media-item': CoffeeListMediaItem,
      'coffee-list-info-item': CoffeeListInfoItem
    },
    computed: mapState({
      coffees: state => state.items
    }),
    mounted() {
      axios({ method: "GET", "url": "http://localhost:8080/coffees/findAll"}).then(result => {
          this.$store.dispatch("setItemsAsync", result.data);
      }, error => {
        console.error(error);
      });
    }
  }
</script>
