<template>
  <div>
    <top-menu />

    

    <div class="main-container">

      {{newProfile}}


      <form
        v-on:submit.prevent="submitProfile"
        v-if="
          this.$store.state.user.username === profile.username || this.profile.username == null
        "
      >
        <input type="text" v-model="newProfile.bio" placeholder="Add your bio here!" />

        <div class="navigation-link">
          <button
            @click="openUploadModal"
            tag="i"
            class="fa fa-plus-square"
          ></button>
        </div>

        <input type="submit" value="Save Profile" />
      </form>


      <!-- Profile pic -->
      <div></div>
      <div>
        <img src='profileUrl' alt="profile picutre" />
      </div>


      <!-- Bio -->
      <div>{{ this.profile.bio }}</div>


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


  methods: {
    openUploadModal() {
      window.cloudinary
        .openUploadWidget(
          { cloud_name: "te-gram2022", upload_preset: "o1kxq5jo" },
          (error, result) => {
            if (!error && result && result.event === "success") {
              this.$store.state.upload = result.info;
              console.table(this.$store.state.upload);
               const profileUrl = this.$store.state.upload.secure_url;
               console.log(profileUrl)
            }
          }
        )
        .open();
    },
    submitProfile() {
      console.log("what im sending")
      console.log(this.profile);
      serverService.addNewProfile(this.newProfile).then(() => {});
    },
  },

  data() {

    return {
     
      newProfile : {
        username :  this.$store.state.user.username,
         profileUrl : ''
      },
      profile: {
      },
      userPictures: [],
    };
  },
  created() {
    console.log("STORE USER: " + this.$store.state.user.username);

    serverService
      .listByUser(this.$store.state.user.username)
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