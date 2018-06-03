<template>
  <div class="columns">
    <coffee-list-media-item></coffee-list-media-item>
    <coffee-list-info-item></coffee-list-info-item>
  </div>
</template>
<script>
  import CoffeeListMediaItem from "./CoffeeListMediaItem.vue";
  import CoffeeListInfoItem from "./CoffeeListInfoItem.vue";

  export default{
    components: {
      'coffee-list-media-item': CoffeeListMediaItem,
      'coffee-list-info-item': CoffeeListInfoItem
    },
  }
</script>
