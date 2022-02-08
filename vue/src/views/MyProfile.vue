<template>
  <div>
    <top-menu />
    <!-- Profile pic -->

    <!-- Bio -->

    <!-- Uploaded photos by user -->
    <div v-for="pic in userPictures" :key="pic.id">
      <div class="photos">
        <img :src="pic.url" width="300px" length="300px" alt="" />
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
      // profile: {
      //  username = "",
      //  bio = "",
      //  profilePic = ""
      // },
      userPictures: [],
    };
  },
  created() {
    serverService
      .listByUser(this.$store.state.user.username)
      .then((response) => {
        this.userPictures = response.data;
      });
  },
};
</script>

<style>
.pictures{
  margin: 10px;
  padding: 20px;
}
</style>