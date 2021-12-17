<template>
  <div id="volunteer-form-button">
    <!-- this is the volunteer form button that displays on the homepage -->

    <h1>Submit Your Volunteer Application!</h1>

    <router-link to="/volunteer-form" tag="button" class="button-style"
      >Sign Up</router-link
    >
  </div>
</template>

<script>
export default {};
</script>

<style>
.button-style {
  color: #2d292c;
  cursor: pointer;
  background: linear-gradient(0.25turn, #e6d0f7, #d7d1dd);
  border-radius: 15px;
  margin-right: 15px;
  margin-bottom: 1.3em;
  width: 150px;
  height: 50px;
  font-size: 1.5rem;
  font-family: "Quicksand", sans-serif;
  font-weight: bold;
}
</style>