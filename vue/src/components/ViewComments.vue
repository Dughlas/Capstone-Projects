<template>
  <div class="main-comment-containter">
    <div v-for="comment in allComments.slice(0, 2)" :key="comment.id">
      <div>{{ comment.username }}</div>
      <div>{{ comment.comment }}</div>
    </div>

    <button id="comment-history-btn" v-on:click="showComments = true">
      Show Comment History
    </button>

    <div id="show-all-comments" v-if="showComments === true">
      <div v-for="comment in allComments.slice(2)" :key="comment.id">
        <div>{{ comment.username }}</div>
        <div>{{ comment.comment }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import ServerService from "../services/ServerService.js";
export default {
  name: "view-comments",
  props: ["picId", 
  ], 
  data() {
    return {
      showComments: false,
      allComments: [],
      comment: {
        photoId: this.picId,
      }
    };
  },
  created() {
    ServerService.listCommentsByPhoto(this.picId).then((response) => {
      console.log(response.data);
      this.allComments = response.data;
    });
  },
  methods: {
  }
};
</script>

<style>
#comment-history-btn {
  border: 2px solid black;
}
</style>