<template>
  <div>
    {{this.like.isLiked}}
    <span>
      <button  
      v-on:click.prevent="flipStatus()"
      title="Like Photo">
        <i
          class="far fa-thumbs-up"
          data-fa-transform="shrink-10 up-.5"
          data-fa-mask="fas fa-comment"
        ></i></button
    ></span>
    {{ this.likeCount }}
    
    
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
        isLiked: false
      },
    };
  },
  created() {
    ServerService.likeCount(this.like.photoId).then((response) => {
      this.likeCount = response.data;
      }),

    ServerService.getLikedStatus(this.like).then((response) =>{
      this.like.isLiked = response.data;
      })
   
  },
  methods: {
  
    flipStatus() {
        if(!this.like.isLiked) {
          ServerService.addLike(this.like).then(() => {
        this.likeCount +=1;
        this.like.isLiked = true
      });
        
        } else if(this.like.isLiked) {
            ServerService.subtractLike(this.like).then(() => {});
            this.likeCount -=1;
            this.like.isLiked = false;
        }
      
    }
    
  }
};
</script>

<style>
</style>