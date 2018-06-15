<template>
  <section class="section is-paddingless">
      <div class="tabs container">
        <ul>
          <li class="is-active"><a>Best</a></li>
          <li><a>New</a></li>
          <li><a>Worst</a></li>
        </ul>
      </div>
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
