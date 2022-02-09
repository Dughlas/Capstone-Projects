<template>
<div>
  <user-posts />


  <div class="flex-container">
    <div v-for="pic in userPicutres" :key="pic.Id">
      <div v-bind:pic-username="pic.username">{{ pic.username }}</div>
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
import UserPosts from "../components/UserPosts.vue";
import AddComments from "../components/AddComments.vue";
// import serverService from "../services/ServerService.js";
import ViewComments from "../components/ViewComments.vue";
import LikeButton from "../components/LikeButton.vue";
import AddToFavorites from "../components/AddToFavorites.vue";
export default {
  name: "userPage",
  components: {
    AddComments,
    ViewComments,
    LikeButton,
    AddToFavorites,
    UserPosts,
  },
  props: [
    "userPictures"
  ]


};
</script>

<style>
</style>