<template>
  <div class="column is-three-quarter">
    <div class="card">
        <div class="card-content">
            <div class="content">
                <coffee-list-info-item-rating v-for="rating in ratings" :key="rating">
                </coffee-list-info-item-rating>
            </div>
        </div>
    </div>
  </div>
</template>
<script>
  import CoffeeListInfoItemDescription from  "./CoffeeListInfoItemDescription.vue";
  import CoffeeListInfoItemRating from "./CoffeeListInfoItemRating.vue";

  export default{
    components:{
      'coffee-list-info-item-description':CoffeeListInfoItemDescription,
      'coffee-list-info-item-rating': CoffeeListInfoItemRating
    },
    data(){
        return {
          ratings: [1,2,3,4]
        };

    }
  }
</script>
