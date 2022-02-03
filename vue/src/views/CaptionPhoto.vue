<template>
  <div>
      <!-- place photo thumbnail here -->
      <img v-bind:src="$store.state.upload.url" alt="photo thumbnail?"/> <br/>
      <form >
      <input type="text" v-model="newPic.caption" placeholder="caption your photo" />
      <input type="submit" v-on:submit.prevent='newPost'/>
      </form>
      userId
      url
  </div>
</template>

<script>
import ServerService from '../services/ServerService.js'
export default {
  data () {
    return {
      newPic: {
        userId: this.$store.state.userId,
        url: this.$store.state.upload.url
      }
    }
  },

  created() {
    console.log(this.$store.state.upload.url)
  },

  methods: {
    newPost() {
      ServerService.addNewPic(this.newPic).then(
        () => {
          console.log('Added Thingy');
      
        }
      )
    },
    test(){
      console.log('Kinda thingy')
    }
  }
}
</script>

<style>

</style>