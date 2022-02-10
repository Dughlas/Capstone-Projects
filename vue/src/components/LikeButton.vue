<template>
  <div>
    <span>
      <button
        id="like-button"
        v-on:click.prevent="flipStatus($event)"
        title="Like Photo"
      >
        <i
          class="far fa-heart"
          data-fa-transform="shrink-10 up-.5"
          data-fa-mask="fas fa-comment"
        ></i></button
    ></span>
    {{ this.likeCount }}
  </div>
</template>

<script>
import ServerService from "../services/ServerService.js";
export default {
  name: "like-button",
  props: ["picId"],
  data() {
    return {
      likeCount: 0,
      like: {
        username: this.$store.state.user.username,
        photoId: this.picId,
        isLiked: false,
      },
    };
  },
  created() {
    ServerService.likeCount(this.like.photoId).then((respsonse) => {
      this.likeCount = respsonse.data;
      this.like.isLiked = ServerService.getLikedStatus(this.like);
    });
  },
  methods: {
    flipStatus(event) {
      const icon = event.target;
      if (!this.isLiked) {
        ServerService.addLike(this.like).then(() => {
          this.likeCount += 1;
          this.isLiked = true;
          icon.classList.add("change-color");
        });
      } else if (this.isLiked) {
        ServerService.subtractLike(this.like).then(() => {});
        this.likeCount -= 1;
        this.isLiked = false;
        icon.classList.remove("change-color");
      }
    },
  },
};
</script>

<style>
.change-color {
  color: #ffa69e;
}
</style>