<template>
  <div id="pets-display">
    <pet-card
      id="pet-card"
      v-for="pet in $store.state.pets"
      v-bind:key="pet.id"
      v-bind:pet="pet"
    />
  </div>
</template>

<script>
import petServices from "@/services/PetServices.js";
import PetCard from "@/components/PetCard.vue";

export default {
  components: {
    PetCard,
  },
  created() {
    petServices.displayPets().then((response) => {
      this.$store.state.pets = response.data;
    });
  },
};
</script>

<style>
#pets-display {
  text-align: center;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  margin-bottom: 100px;
}
</style>