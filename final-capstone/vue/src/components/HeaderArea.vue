<template>
  <div id="head1">
    <div class="header-image">
      <img src="@/assets/animalshelter1.png" />
    </div>
    <div class="navigation">
      <nav-bar />
    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";

export default {
  components: {
    NavBar,
  },
};
</script>

<style scoped>
#head1 {
  background: #d7d0dd;
}
.header-image {
  grid-area: logo;
}

.header-image img {
  width: 250px;
  height: 100%;
  margin-left: 0px;
  margin-right: 265px;
}

.navigation {
  grid-area: links;
}

#head1 {
  display: grid;
  align-items: center;
  justify-items: center;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "logo links"
    "logo links";
}
</style>