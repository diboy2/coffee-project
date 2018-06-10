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

  export default{
    components: {
      'coffee-list-media-item': CoffeeListMediaItem,
      'coffee-list-info-item': CoffeeListInfoItem
    },
    data() {
      return {
        coffees: []
      }
    },
    mounted() {
      axios({ method: "GET", "url": "http://localhost:8080/coffees/findAll"}).then(result => {
          this.coffees = result.data;
      }, error => {
        console.error(error);
      });
    }
  }
</script>
