<template>
      <div class="column is-half">
          <div class="columns">
              <div class="column is-two-fifths">
                  {{heading}}
              </div>
              <div class="column is-three-fifths">
                  <progress class="progress" value="15" max="100">15%</progress>
              </div>
          </div>
      </div>
</template>

<script>
  export default {
    props: {
      heading: String
    }
  }
</script>
