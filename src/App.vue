<template>
  <div id="app">
      <app-header> </app-header>
      <app-content></app-content>
  </div>
</template>

<script>
  import AppHeader from "./components/AppHeader.vue";
  import AppContent from "./components/AppContent.vue";

  import store from "./store/index.js";

  export default {
    components: {
      'app-header': AppHeader,
      'app-content': AppContent
    },
    name: 'app',
    store,
    data () {
      return {
        msg: 'Welcome to Your Vue.js App'
      }
    }
  }
</script>

<style lang="scss">
@import '~bulma/bulma.sass';
@import '~bulma-carousel/dist/css/bulma-carousel.sass';
</style>
