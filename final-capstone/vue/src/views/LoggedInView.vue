<template>
  <div id="logged-in-form" v-if="$store.state.token != ''">
    <router-link
      tag="button"
      v-bind:to="{ name: 'add-pet' }"
      id="add"
      class="button-style"
      >Add Pet</router-link
    >
  </div>
</template>

<script>
export default {};
</script>

<style>
.links {
  margin: 6px;
}
#add{
  margin-top: 50px;
  
}

</style>