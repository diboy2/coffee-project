import Vue from 'vue';
import Vuex from 'vuex';
import axios from "axios";
import {
  FIREBASE_CONFIG
} from "../constants.js";
import firebase from "firebase";

Vue.use(Vuex);
firebase.initializeApp(FIREBASE_CONFIG);

export default new Vuex.Store({
  state: {
    items: [],
    currentUser: firebase.auth().currentUser,
    showLoginModal: false
  },
  mutations:  {
    setItems(state, items) {
      state.items = items;
    },
    setUser: state => {
      state.currentUser = firebase.auth().currentUser;
    },
    showLoginModal: state=> {
      state.showLoginModal = true;
    },
    hideLoginModal: state => {
      state.showLoginModal = false;
    }
  },
  actions: {
    setItemsAsync({commit}, items){
      commit('setItems', items);
    },
    filterItemsByName({commit}, value){
      axios({
        method: "GET",
        url: `http://localhost:8080/coffees?name=${value}`
      }).then(result => {
        commit('setItems', result.data);
      }, error => {
        console.error(error);
      });
    },
    loginUser({commit}){
      commit("setUser");
      commit("hideLoginModal");
    },
    hideShowLoginModal({commit}, isShown){
      isShown? commit("showLoginModal") : commit("hideLoginModal");
    },
    signOutUser({commit}){
      commit("setUser");
    }
  }
});
