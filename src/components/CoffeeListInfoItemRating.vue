<template>
      <div class="column is-half">
          <div class="columns">
              <div class="column is-two-fifths">
                  {{heading}}
              </div>
              <div class="column is-three-fifths" v-if="showSlider">
                <vue-slider v-model="value" v-bind:min="min" v-bind:max="max"></vue-slider>
              </div>
              <div class="column is-three-fifths" v-else>
                 <progress class="progress" value="15" max="100">15%</progress>
              </div>
          </div>
      </div>
</template>

<script>
  import vueSlider from "vue-slider-component";

  export default {
    components: {
      vueSlider
    },
    props: {
      heading: String,
      showSlider: true,
      index: Number
    },
    data() {
      return {
        value: 0,
        min: 0,
        max: 10
      };
    },
    watch: {
      value(value) {
        this.$emit("rating-change",{
          index: this.index,
          value
        });
      }
    }
  }
</script>
