<template>
  <div class="petcard">
    <div class="img-container">
      <img v-bind:src="pet.pic" />
    </div>
    <h2>{{ pet.name }}</h2>
    <p class="description">Description: {{ pet.description }}</p>
    <p>Type: {{ pet.pet_type }}</p>
    <p>Breed: {{ pet.breed }}</p>

    <!-- This part makes sure you are logged in or that your token is not empty 
inorder to display the edit pet button -->
    <router-link
      tag="button"
      class="button-style"
      v-if="$store.state.token != ''"
      v-bind:to="{ name: 'update-pet', params: { id: pet.pet_id } }"
      >Edit Pet</router-link
    >
  </div>
</template>

<script>
export default {
  name: "pet-card",
  props: ["pet"],
};
</script>

<style>
.img-container {
  width: 100%;
  height: 250px;
  overflow: hidden;
}

.img-container img {
  width: 80%;
  height: 100%;
  object-fit: cover;
  object-position: center;
}
.button-style {
  border: none;
}
.description {
  margin-left: 55px;
  margin-right: 55px;
}
p {
  text-align: left;
  margin-left: 55px;
  margin-right: 55px;
}
</style>