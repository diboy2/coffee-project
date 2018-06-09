<template>
   <div class="columns">
      <div class="column">
          <div class="columns">
              <div class="column is-one-fifth">
                  {{heading}}
              </div>
              <div class="column is-fourth-fifths">
                  <progress class="progress" value="15" max="100">15%</progress>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
  export default {
    props:{
      heading: ""
    }
  }
</script>
