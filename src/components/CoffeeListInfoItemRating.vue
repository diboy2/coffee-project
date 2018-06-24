<template>
      <div class="column is-half">
          <div class="columns">
              <div class="column is-two-fifths">
                  {{heading}}
              </div>
              <div class="column is-three-fifths" v-if="showSlider">
                  <input class="slider is-fullwidth" step="1" min="0" max="100" value="50" type="range">
              </div>
              <div class="column is-three-fifths" v-else>
                  <progress class="progress" value="15" max="100">15%</progress>
              </div>
          </div>
      </div>
</template>

<script>
  import bulmaSlider from "bulma-slider";

  export default {
    props: {
      heading: String,
      showSlider: true
    },
    mounted(){
      if(this.showSlider){
        bulmaSlider.attach();
      }
    }
  }
</script>
