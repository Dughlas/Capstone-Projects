<template>
  <div>

      <!-- not sure if we need this component anymore -->
    <form>
      <input type="text" placeholder="add a comment..." />
      <button>Comment</button>
    </form>
  </div>
</template>

<script>
import ServerService from "../services/ServerService";
export default {
  data() {
    return {
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
      });
    },
  },
};
</script>

<style>
</style>