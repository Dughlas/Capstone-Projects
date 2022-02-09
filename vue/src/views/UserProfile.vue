<template>
  <div>
    <top-menu />

    

    <div class="main-container">

    

      <!-- Profile pic -->
      <div></div>
      <div>
        <img src="" alt="profile picutre" />
      </div>

      <!-- Bio -->
      <div>{{ this.profile.bio }}</div>
      {{picUsername}}

      <!-- Uploaded photos by user -->
      <div class="flex-container">
        <div v-for="pic in userPictures" :key="pic.Id">
          <p><img :src="pic.url" width="500px" length="500px" alt="" /></p>
          <div v-bind:src="pic"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopMenu from "../components/TopMenu.vue";
import serverService from "../services/ServerService.js";

export default {
  name: "my-profile",
  components: { TopMenu },


  data() {

    return {
        props:['picUsername'],
      //profileUrl : '',
      newProfile : {
        username :  this.$store.state.user.username,
        
      },
      profile: {

      },
      userPictures: [],
    };
  },
  created() {
    console.log("STORE USER: " + this.$store.state.user.username);

    serverService
      .listByUser()
      .then((response) => {
        this.userPictures = response.data;
      });
    serverService
      .getProfile(this.$store.state.user.username)
      .then((response) => {
        console.log(response.data);
        this.profile = response.data;
        console.log(this.profile.username);
      });
  },
};
</script>

<style>
.pictures {
  margin: 10px;
  padding: 20px;
}

.main-container {
  margin: 150px;
}
</style>