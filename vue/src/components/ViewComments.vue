<template>
  <div class="main-comment-containter">
    <div v-for="comment in allComments" :key="comment.id">
      {{comment.commentId}}
      <div>{{ comment.username }}</div>
      <div>{{ comment.comment }}</div>
    </div>
  </div>
</template>

<script>
import ServerService from "../services/ServerService.js";
export default {
  name: "view-comments",
  props: ["picId"],

  data() {
    return {
      allComments: [],
      comment: {
        photoId: this.picId,
      },
    };
  },
  created() {
    ServerService.listCommentsByPhoto(this.picId).then((response) => {
      console.log(response.data);
      this.allComments = response.data;
    });
  },
};
</script>

<style>
</style>