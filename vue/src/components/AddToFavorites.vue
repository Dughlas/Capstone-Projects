<template>
  <div>
    <span>
      <button v-on:click="addToFavorites()">
        <i
          class="far fa-heart"
          data-fa-transform="shrink-3.5 down-1.6 right-1.25"
          data-fa-mask="fas fa-circle"
        ></i>
      </button>
    </span>
  </div>
</template>

<script>
import ServerService from "../services/ServerService.js";
export default {
  name: "favorties",
  props: ["picId"],
  data() {
    return {
      favorite: {
        username: this.$store.state.user.username,
        photoId: this.picId,
      },
    };
  },
  methods: {
    addToFavorites() {
      ServerService.addToFavorites(this.favorite).then(() => {});
    },
  }
};
</script>

<style>
</style>