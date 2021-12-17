<template>
  <div id="home">
    <div class="head2">
      <header-area />
    </div>
    <!--added "logged in view here with a div around it-ang -->
    <div class="logged-in-view">
      <logged-in-view />
    </div>
    <div class="pets-area">
      <pets-display />
    </div>
    <div class="volunteer">
      <volunteer-form />
    </div>
    <div class="footer2">
      <footer-area />
    </div>
  </div>
</template>

<script>
import HeaderArea from "@/components/HeaderArea.vue";
import PetsDisplay from "@/components/AvailablePetsDisplay.vue";
import VolunteerForm from "@/views/VolunteerForm.vue";
import FooterArea from "@/components/FooterArea.vue";
import LoggedInView from "@/views/LoggedInView.vue";

export default {
  name: "home",
  components: {
    HeaderArea,
    PetsDisplay,
    VolunteerForm,
    FooterArea,
    LoggedInView,
  },
};
</script>

<style scoped>
/*
Grid Layout
added a grid area for logged in view -ang
*/
.head2 {
  grid-area: header;
}

.logged-in-view {
  grid-area: logged-in-view;
}

.pets-area {
  grid-area: pet-display;
  margin-top: 100px;
}

.volunteer {
  grid-area: vform;
  margin-bottom: 75px;
}

.footer2 {
  grid-area: footer;
}

/* 
Desktop Layout
added "logged-in-view" to grid areas -ang
*/

#home {
  text-align: center;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "header header"
    "logged-in-view logged-in-view"
    "pet-display pet-display"
    "vform vform"
    "footer footer";
}
</style>