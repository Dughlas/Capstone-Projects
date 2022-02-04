<template>
  <div class="post">
    <h3>{{ this.$store.state.user.username }}</h3>
    <img src="" alt="" />

    <div class="btn">
      buttons go here
      <button id="likeBtn">Like</button>
      <button id="favBtn">Favorite</button>

      <button
        id="commentBtn"
        v-if="showForm === false"
        v-on:click.prevent="showForm = true"
      >
        Comment
      </button>

      <form v-if="showForm === true" v-on:submit.prevent="addComment">
        <input type="text" placeholder="add a comment..." />
        <input type="submit" value="Comment" />
      </form>
    </div>

    <p class="caption-section">{{ thi$store.state.comment.commentText }}</p>
    <!-- v-if to show comments only when viewing details -->

    <p class="comment-section">Comments</p>
  </div>
</template>

<script src="https://kit.fontawesome.com/ec629aff38.js" crossorigin="anonymous">
import ServerService from "../services/ServerService";
export default {
  name: "",
  data() {
    return {
      showForm: false,
      comment: {
        commentText: "this is a comment",
        commentId: 1,
        username: "test",
      },
    };
  },
  methods: {
    addComment() {
      ServerService.addNewComment(this.comment).then(() => {
        console.log("Added Comment");
        //TODO: redirect to photo details view
        //TODO: reset form?
      });
    },
  },
};
</script>

<style>
.post {
  border: 2px solid darkgray;
}
</style>