<template>
  <nav class="navbar has-shadow" role="navigation" aria-label="main navigation">
      <div class="container">
          <div class="navbar-brand">
              <a class="navbar-item" href="https://bulma.io">
                  <img src="https://bulma.io/images/bulma-logo.png" alt="Bulma: a modern CSS framework based on Flexbox" width="112" height="28">
              </a>

              <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false">
                  <span aria-hidden="true"></span>
                  <span aria-hidden="true"></span>
                  <span aria-hidden="true"></span>
              </a>
          </div>
          <div class="navbar-item">
              <div class="field">
                  <p class="control has-icons-right">
                      <input class="input" placeholder="">
                      <span class="icon is-small is-right">
                          <i class="fas fa-search"></i>
                      </span>
                  </p>
              </div>
          </div>
      </div>
  </nav>
</template>
<script>
const debounceEvent = (callback, time = 250, interval) =>
  (...args) => {
    clearTimeout(interval, interval = setTimeout(() => callback(...args), time));
  };


</script>
