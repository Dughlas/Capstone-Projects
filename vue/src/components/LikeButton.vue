<template>
  <div>
    <span>
      <button
      v-on:click="addLike()"
      v-on:dblclick="subtractLike()"
      title="Like Photo">
        <i
          class="far fa-thumbs-up"
          data-fa-transform="shrink-10 up-.5"
          data-fa-mask="fas fa-comment"
        ></i></button
    ></span>
    {{this.likeCount}}
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
      }
    };
  },
  created() {
    ServerService.addLike(this.like).then(() => {}),
    ServerService.likeCount(this.like.photoId).then((respsonse) => {
      this.likeCount = respsonse.data;
    }),
    ServerService.subtractLike(this.like).then(() => {})
  },
};
</script>

<style>
</style>