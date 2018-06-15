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

<style{{#sass}} lang="scss"{{/sass}}>
</style>
