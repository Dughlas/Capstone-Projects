<template>

<div class="post">

  <h3 >{{this.$store.state.user.username}}</h3>
  <img src="" alt="">

  <div class="btn">buttons go here
    <button id="likeBtn">Like</button>
    <button id="favBtn">Favorite</button>

    <button id="commentBtn" 
    v-if="showForm === false"
    v-on:click.prevent="showForm = true">Comment</button>
  </div>

  <p class="caption-section">{{thi$store.state.comment.commentText}}</p>
  <!-- v-if to show comments only when viewing details? -->
  <p class="comment-section">Comments</p> 

</div>


</template>

<script src="https://kit.fontawesome.com/ec629aff38.js" crossorigin="anonymous">
export default {
  name: "",
  data() {
    return {
      showForm: false
    }
  }

}
</script>

<style>
.post {
  border: 2px solid darkgray;
}

</style>