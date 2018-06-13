<template>
  <div class="modal" v-bind:class="{ 'is-active':showLoginModal}">
    <div class="modal-background">
    </div>
    <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title">Modal title</p>
          <button class="delete" aria-label="close" v-on:click="hideLoginModal"></button>
        </header>
        <section class="modal-card-body">
          <div class="field">
            <p class="control has-icons-left has-icons-right">
              <input class="input" type="email" v-model="email" placeholder="Email">
              <span class="icon is-small is-left">
                <i class="fas fa-envelope"></i>
              </span>
              <span class="icon is-small is-right">
                <i class="fas fa-check"></i>
              </span>
            </p>
          </div>
          <div class="field">
            <p class="control has-icons-left">
              <input class="input" type="password" v-model="password" placeholder="Password">
              <span class="icon is-small is-left">
                <i class="fas fa-lock"></i>
              </span>
            </p>
          </div>
        </section>
        <footer class="modal-card-foot">
          <button class="button" v-on:click="login">Login</button>
          <button class="button">
            Sign Up
          </button>
        </footer>
    </div>
  </div>
</template>
<script>
  import firebase from 'firebase';
  import { mapState } from 'vuex';
  export default {
    data(){
      return {
        email: "",
        password: ""
      }
    },
    computed: mapState({
      showLoginModal: state => state.showLoginModal
    }),
    methods: {
      login() {
        firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(()=>{
            this.$store.dispatch("loginUser");
            console.log("success");
        }).catch(() => {
            console.log("you fail");
        });
      },
      signUp(){
        firebase.auth().createUserAndRetrieveDataWithEmailAndPassword(this.email, this.password).then(()=> {
          this.$store.dispatch("loginUser");
          console.log("success");
        }).catch(() => {
          console.log("you fail");
        });
      },
      hideLoginModal(){
        this.$store.dispatch("hideShowLoginModal",false);
      }
    }
  };
</script>
