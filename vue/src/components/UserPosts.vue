<template>
<div>
  <top-menu />

<div class="tiny-pic-dad">
 <img :src="profile.profilePicUrl"  class= "tiny-pic"/>
 </div>
<div>{{profile.bio}}</div>


<div class="flex-container">

<form
        v-on:submit.prevent="submitProfile()"
        v-if="this.$store.state.user.username === this.$route.params.username">
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


    <div v-for="pic in userPictures" :key="pic.Id">
      <!-- <div v-bind:pic-username="pic.username">{{ pic.username }}</div> -->
      <h1>{{pic.username}}</h1>
      <p><img :src="pic.url" width="500px" length="500px" alt="" /></p>
      <p class="caption">{{ pic.caption }}</p>
      <div v-bind:src="pic"></div>

      <!-- call buttons here -->
      <div class="buttons">
        <span>
          <like-button v-bind:pic-id="pic.photoId" />
        </span>
        <span>
          <view-comments v-bind:pic-id="pic.photoId" />
        </span>
        <span>
          <add-to-favorites v-bind:pic-id="pic.photoId" />
        </span>
        <span>
          <add-comments v-bind:pic-id="pic.photoId" />
        </span>
      </div>
    </div>
  </div>


</div>

</template>

<script>
import serverService from "../services/ServerService.js";
import AddComments from "../components/AddComments.vue";
import ViewComments from "../components/ViewComments.vue";
import LikeButton from "../components/LikeButton.vue";
import AddToFavorites from "../components/AddToFavorites.vue";
import TopMenu from "../components/TopMenu.vue";


export default {
    name: 'userPosts',
    props: ["selectedUser"],
    
    components: {
    AddComments,
    ViewComments,
    LikeButton,
    AddToFavorites,
    TopMenu,

    },

      data() {
    return {
      profileUrl: '',
      userPictures: [],

      profile: {
        username : this.$route.params.username,
        
        
      },
      newProfile: {
        username: this.$store.state.user.username,
        
        
      }
    }
  },
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
      this.newProfile.profilePicUrl = this.$store.state.upload.secure_url;
      serverService.addNewProfile(this.newProfile)
    }

  },

    created() {
serverService.listByUser(this.$route.params.username).then((response) => {
        console.log(response.data);
        this.userPictures = response.data;
      });

      serverService.getProfile(this.profile.username).then((response) => {
        this.profile = response.data;
      })
    }
}

</script>

<style>
.box{
    padding: 150px;
}

.flex-container {
  padding: 150px;
}

.tiny-pic{
  width: 100px;
  height: 100px;
  border-radius: 50%;
  
}

.tiny-pic-dad{
  padding: 100px;
  
}

</style>