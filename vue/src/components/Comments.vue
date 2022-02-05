<template>
  <div>
    <a
      id="show-form-button"
      href="#"
     v-on:click="showForm = true"
    >Show Form{{picId}}</a>
    

      
    <form v-on:submit.prevent="addComment" v-if="showForm === true" class = "comment-form" >

     <div class="form-element"> <input id="comment" type="text" v-model="comment.comment" /></div>

     
      <input type="submit" value="Add Comment" />
        
    </form>
  </div>
</template>

<script>
import ServerService from "../services/ServerService";
export default {
  name: "comments",
  props:['picId'],
  data() {
    return {
      showForm: false,
      comment: { 
        username: this.$store.state.user.username,
        photoId: this.picId,
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