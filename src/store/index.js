import Vue from 'vue';
import Vuex from 'vuex';
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    items: []
  },
  mutations:  {
    setItems(state, items) {
      state.items = items;
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

    }
  }
});
