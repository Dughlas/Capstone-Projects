<template>
  <div>
    <button
      id="show-form-button"
      href="#"
     v-on:click="showForm = true"
    >Show Form</button>
    

      
    <form v-on:submit.prevent="addComment" v-if="showForm === true" class = "comment-form" v-bind:src="pic.id">

     <div class="form-element"> <input id="comment" type="text" v-model="comment.comment" /></div>

     
      <input type="submit" value="Add Comment" />
        
    </form>
  </div>
</template>

<script>
import ServerService from "../services/ServerService";
export default {
  name: "comments",
  data() {
    return {
      showForm: false,
      comment: {
        //photoId: this., 
        username: this.$store.state.user.username,
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
.comment-form {
  margin: 200px;
}

.form-element{
  height: 10px;
}

</style>