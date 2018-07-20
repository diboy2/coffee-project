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
    showLoginModal: false,
    showCreateBlendModal: false,
    blends: []
  },
  mutations:  {
    addBlend(state, blend){
      state.blends.push(blend);
    },
    setBlends(state, blends){
      state.blends = blends;
    },
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
    },
    showCreateBlendModal: state => {
      state.showCreateBlendModal = true;
    },
    hideCreateBlendModal: state => {
      state.showCreateBlendModal = false;
    }
  },
  actions: {
    saveRatings({commit}, data){
      axios({
        method: "POST",
        url: `http://localhost:8080/rating-groups`
      }).then(results => {
        
      }, error => {
        console.error(error);
      });
    },
    addBlend({commit}, data){
      axios({   
        method: "POST",
        url: `http://localhost:8080/blends`,
        data
      }).then(results => {
        commit("addBlend", results.data);
        commit("hideCreateBlendModal");
      }, error => {
        console.error(error);
      });
    },
    getBlends({commit}){
      axios({
        method: "GET",
        url: `http://localhost:8080/blends`
      }).then(result => {
        commit('setBlends', result.data);
      }, error => {
        console.error(error);
      });
    },
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
    hideShowCreateBlendModal({commit}, isShown){
      isShown? commit("showCreateBlendModal") : commit("hideCreateBlendModal");
    },
    signOutUser({commit}){
      commit("setUser");
    }
  }
});
