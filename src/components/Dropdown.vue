<template>
<div class="dropdown is-hoverable">
  <div class="dropdown-trigger">
    <button class="button" aria-haspopup="true" aria-controls="dropdown-menu">
      <span>{{dropdownItems[currentlySelectedDropdownItemKey]}}</span>
      <span class="icon is-small">
        <i class="fas fa-angle-down" aria-hidden="true"></i>
      </span>
    </button>
  </div>
  <div class="dropdown-menu" id="dropdown-menu" role="menu">
    <div class="dropdown-content">
      <a href="#" class="dropdown-item" v-for="(dropdownItem, key) in dropdownItems" v-bind:key="key" v-on:click="setSelectedDropdownItem(key)">
        {{dropdownItem}}
      </a>
    </div>
  </div>
</div>
</template>

<script>


  export default {
    props: {
      dropdownItems: Object,
      currentlySelectedDropdownItemKey: String
    },
    methods: {
      setSelectedDropdownItem(key){
        this.currentlySelectedDropdownItemKey = key;
        this.$emit('update', key);
      }
    }
  };
</script>
