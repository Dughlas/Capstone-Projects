<template>
  <div>
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
      isLiked: false,
      like: {
        username: this.$store.state.user.username,
        photoId: this.picId
      },
    };
  },
  created() {
    ServerService.likeCount(this.like.photoId).then((respsonse) => {
      this.likeCount = respsonse.data;
      this.isLiked = ServerService.getLikedStatus(this.like)
    }
    );
  },
  methods: {
  
    flipStatus() {
        if(!this.isLiked) {
          ServerService.addLike(this.like).then(() => {
        this.likeCount +=1;
        
      });
          this.isLiked = true
        } else if(this.isLiked) {
            ServerService.subtractLike(this.like).then(() => {});
            this.likeCount -=1;
            this.isLiked = false;
        }
      
    }
    
  }
};
</script>

<style>
</style>