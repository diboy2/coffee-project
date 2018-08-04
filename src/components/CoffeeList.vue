<template>
  <div class="container">
    <div class="columns" v-for="coffee in coffees" :key="coffee.id" >
      <coffee-list-media-item v-bind:coffee="coffee" ></coffee-list-media-item>
      <coffee-list-info-item v-bind:coffee="coffee"></coffee-list-info-item>

    </div>
  </div>
</template>
<script>
  import CoffeeListMediaItem from "./CoffeeListMediaItem.vue";
  import CoffeeListInfoItem from "./CoffeeListInfoItem.vue";
  import { mapState } from 'vuex';

  export default{
    components: {
      'coffee-list-media-item': CoffeeListMediaItem,
      'coffee-list-info-item': CoffeeListInfoItem
    },
    computed: mapState({
      coffees: state => state.blends
    }),
    mounted() {
      this.$store.dispatch("getBlends");
    }
  }
</script>
