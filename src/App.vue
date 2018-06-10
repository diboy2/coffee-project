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
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
