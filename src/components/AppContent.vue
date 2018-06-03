<template>
  <section class="section">
        <div class="container">
          <coffee-list></coffee-list>
        </div>
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
