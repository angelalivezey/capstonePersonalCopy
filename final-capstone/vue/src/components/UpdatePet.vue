<template>
  <div id="add-pet">
    <header-area />
    <h1>Edit Pet</h1>

    <form class="new-pet" v-on:submit.prevent="updatePet">
      <div class="form-group">
        <div class="status-message success" v-show="message !== ''">
          {{ message }}
        </div>
      </div>
      <!--Pet Name-->
      <div class="form-group">
        <label for="name">Pet Name:</label>
        <input
          id="name"
          type="text"
          class="form-box"
          v-model="selectedPet.name"
          autocomplete="off"
        />
      </div>
      <!--Description-->
      <div class="form-group">
        <label for="description">Description:</label>
        <input
          id="description"
          type="text"
          class="form-box"
          v-model="selectedPet.description"
          autocomplete="off"
        />
      </div>
      <!--pic-->
      <div class="form-group">
        <label for="pic">Add a link for your picture:</label>
        <input
          id="pic"
          type="text"
          class="form-box"
          v-model="selectedPet.pic"
          autocomplete="off"
        />
      </div>
      <!--breed-->
      <div class="form-group">
        <label for="breed">Breed:</label>
        <input
          id="breed"
          type="text"
          class="form-box"
          v-model="selectedPet.breed"
          autocomplete="off"
        />
      </div>
      <!--type-->
      <div class="form-group">
        <label for="pet-type">Type of Animal:</label>
        <input
          id="pet-type"
          type="text"
          class="form-box"
          v-model="selectedPet.pet_type"
          autocomplete="off"
        />
      </div>

      <div class="form-buttons">
        <button class="btn btn-submit">Submit</button>
        <button
          class="btn btn-cancel"
          v-on:click.prevent="cancelForm"
          type="cancel"
        >
          Cancel
        </button>
      </div>
    </form>
    <footer-area />
  </div>
</template>

<script>
import HeaderArea from "./HeaderArea.vue";
import FooterArea from "./FooterArea.vue";
import PetService from "@/services/PetServices.js";

export default {
  name: "update-pet",
  components: {
    HeaderArea,
    FooterArea,
  },
  data() {
    return {
      message: "",
    };
  },
  methods: {
    updatePet() {
      const newPet = {
        pet_id: this.selectedPet.pet_id,
        name: this.selectedPet.name,
        description: this.selectedPet.description,
        is_adoptable: this.selectedPet.is_adoptable,
        pic: this.selectedPet.pic,
        breed: this.selectedPet.breed,
        pet_type: this.selectedPet.pet_type,
      };
      //changed to 200 code
      PetService.updatePet(newPet)
        .then((response) => {
          if (response.status === 200) {
            this.message = "Pet successfully changed!";
            this.$router.push({ name: "home" });
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "updating");
        });
    },
    cancelForm() {
      this.$router.push({ name: "home" });
    },
    // putting in a getPetById method here for the pet-lookup
    // getPetById(petId) {
    //   this.pet = {};
    // },

    handleErrorResponse(error, verb) {
      if (error.response) {
        this.message =
          "Error " +
          verb +
          " form. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.message = "Error " + verb + " form. Server could not be reached.";
      } else {
        this.message = "Error " + verb + " form. Request could not be created.";
      }
    },
  },

  computed: {
    selectedPet() {
      return this.$store.state.pets.find(
        (pet) => pet.pet_id == this.$route.params.id
      );
    },
  },
};
</script>

<style >
h1 {
  text-align: center;
}

.form-group {
  text-align: left;
  width: 80%;
  margin: 10px auto 10px;
}

.form-buttons {
  text-align: center;
  width: 80%;
  margin: 2em auto 2em;
}

label {
  display: inline-block;
  margin-bottom: 0.5rem;
  font-weight: bold;
}
.form-box {
  display: block;
  width: 99.5%;
  height: 30px;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-box {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}

.btn-submit {
  color: #2d292c;
  cursor: pointer;
  background: linear-gradient(0.25turn, #e6d0f7, #d7d1dd);
  border-radius: 15px;
  margin-right: 15px;
  width: 150px;
  height: 50px;
  font-size: 1.5rem;
  font-family: "Quicksand", sans-serif;
  font-weight: bold;
}

.btn-cancel {
  color: #fff;
  cursor: pointer;
  background-color: #dc3545;
  border-radius: 15px;
  margin-left: 15px;
  width: 150px;
  height: 50px;
  font-size: 1.5rem;
  font-family: "Quicksand", sans-serif;
  font-weight: bold;
}

.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}

.status-message.success {
  background-color: #90ee90;
  margin: auto;
  padding: 0.375rem 0.75rem;
}
</style>