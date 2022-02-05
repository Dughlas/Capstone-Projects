<template>
  <div>
    <span>
      <button>
        <i
          class="far fa-thumbs-up"
          data-fa-transform="shrink-10 up-.5"
          data-fa-mask="fas fa-comment"
        ></i></button
    ></span>
  </div>
</template>

<script>
import ServerService from "../services/ServerService.js";
export default {
  name: "like-button",
  props: ["picId"],
  data() {
    return {
      like: {
        username: this.$store.state.user.username,
        photoId: this.picId,
      },
    };
  },
  created() {
    ServerService.addLike(this.like).then(() => {});
  },
};
</script>

<style>
</style>