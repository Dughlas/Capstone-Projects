<template>
  <div>
    <section>
      <div class="main-flex-container">
        <div class="flex-container">
          <div v-for="pic in allPictures" :key="pic.Id">
            <p class="poster-name">{{ pic.username }}</p>
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
    </section>
  </div>
</template>

<script>
import AddComments from "../components/AddComments.vue";
import serverService from "../services/ServerService.js";
import ViewComments from "../components/ViewComments.vue";
import LikeButton from "../components/LikeButton.vue";
import AddToFavorites from "../components/AddToFavorites.vue";

export default {
  name: "postcard-2",
  components: {
    AddComments,
    ViewComments,
    LikeButton,
    AddToFavorites,
  },

  data() {
    return {
      pictures: [],
      allPictures: [],
    };
  },
  created() {
    serverService.listByUser(this.$store.state.user.username).then(
      (response) => {
        console.log(response.data);
        this.pictures = response.data;
      },
      serverService.listAll().then((response) => {
        console.log(response.data);
        this.allPictures = response.data;
      }),
      serverService.listFavorites().then((response) => {
        this.myFavoritePictures = response.data;
      })
    );
  },
};
</script>

<style>
.main-flex-container {
  display: flex;
  justify-content: center;
  background-color: rgb(245, 245, 240);
  padding: 10px;
  margin: 20px;
}
.flex-container > div {
  background-color: #f1f1f1;
  margin: 10px;
  padding: 20px;
  font-size: 30px;
}

.buttons {
  display: flex;
}
</style>