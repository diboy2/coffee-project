<template>
  <div class="column is-one-quarter">
      <div class="card">
          <header class="card-header">
              <p class="card-header-title">
                  {{coffee.name}}
              </p>
          </header>
          <div class="card-image">
              <figure class="image is-4by3">
                  <img :src="coffee.imageURL" alt="Placeholder image" />

              </figure>
          </div>
          <footer class="card-footer">
              <a href="#" class="card-footer-item">Save</a>
              <a href="#" class="card-footer-item">Edit</a>
              <a href="#" class="card-footer-item">Delete</a>
          </footer>
      </div>
  </div>
</template>
<script>
  export default {
    props: {
      coffee: Object
    }
  }
</script>
