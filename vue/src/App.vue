<template>
  <NavBar></NavBar>
  
  <router-view />
</template>


<script>
import NavBar from './components/NavBar.vue';

export default {
  name: "App",
  components: {
    NavBar
  }

}




</script>



<style scoped>
body {
  background-image: url("../src/assets/image/background.png");
  background-size: cover;
}
</style>
