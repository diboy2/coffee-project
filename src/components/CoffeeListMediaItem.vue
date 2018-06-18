<template>
  <div class="column">
      <div class="card">
        <div class="card-content">
          <div class="content">
            <div class='carousel carousel-animated carousel-animate-slide'  data-autoplay='true'>
              <div class='carousel-container'>
                <div class='carousel-item has-background'  v-for="(ingredient, index) in coffee.ingredients" :key="ingredient.ingredientId" v-bind:class="{ 'is-active': index === 0}">
                  <img class="is-background" v-bind:src="ingredient.imageURL" alt=""  />
                </div>
              </div>
              <div class="carousel-navigation">
                <div class="carousel-nav-left">
                  <i class="fa fa-chevron-left" aria-hidden="true"></i>
                </div>
                <div class="carousel-nav-right">
                  <i class="fa fa-chevron-right" aria-hidden="true"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="card-footer">
          <div class="tags" style="padding: 10px;">
            <span class="tag is-medium" v-for="ingredient in coffee.ingredients" :key="ingredient.ingredientId"><a href="#">{{ingredient.name}}</a></span>
          </div>
        </div>
      </div>
  </div>
</template>
<script>
  import bulmaCarousel from 'bulma-carousel';
  export default {
    props: {
      coffee: Object
    },
    mounted(){
      bulmaCarousel.attach();
    },
    updated(){
      bulmaCarousel.attach();
    }
  }
</script>
