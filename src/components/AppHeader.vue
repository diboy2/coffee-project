<template>
  <nav class="navbar has-shadow container" role="navigation" aria-label="main navigation">

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
                      <input class="input" placeholder="" v-on:keyup="filterItems">
                      <span class="icon is-small is-right">
                          <i class="fas fa-search"></i>
                      </span>
                  </p>
              </div>
          </div>

          <div class="navbar-menu">
            <div class="navbar-end">
              <div class="navbar-item" v-show="!currentUser">
                <button class="button is-primary" v-on:click="showLoginModal">Login</button>
              </div>
              <div class="navbar-item has-dropdown is-hoverable" v-show="currentUser">
                <a class="navbar-link" href="#">
                  <span class="icon">
                  <i class="fas fa-user"></i>
                  </span>
                </a>
                <div class="navbar-dropdown is-right">
                  <a class="navbar-item" href="#">
                    {{currentUser? currentUser.email: ""}}
                  </a>
                  <a class="navbar-item" href="#" v-on:click="signOutUser">
                    Sign Out
                  </a>
                </div>
              </div>
            </div>
          </div>
          <login-modal></login-modal>
  </nav>
</template>
<script>
  import LoginModal from "./LoginModal.vue";
  import { mapState } from 'vuex';
  import firebase from 'firebase';

  export default {
    components: {
      "login-modal": LoginModal
    },
    computed: mapState({
      currentUser: state => state.currentUser
    }),
    methods: {
      filterItems(event){
        this.$store.dispatch("filterItemsByName", event.target.value);
      },
      showLoginModal(){
        this.$store.dispatch("hideShowLoginModal", true);
      },
      signOutUser(){
        firebase.auth().signOut().then(() => {
          this.$store.dispatch("signOutUser");
          console.log("Success");
        }).catch(() => {
          console.log("you fail");
        });
      }
    }
  };
</script>
