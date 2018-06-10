<template>
  <section class="section">
     <coffee-list></coffee-list>
    </section>
</template>
<script>
    import CoffeeList from "./CoffeeList.vue";

    export default {
      components: {
        'coffee-list': CoffeeList,
      },
    }
</script>
