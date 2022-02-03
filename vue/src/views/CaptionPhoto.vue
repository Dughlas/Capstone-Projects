<template>
  <div>
      <!-- place photo thumbnail here -->
      <img v-bind:src="$store.state.upload.url" alt="photo thumbnail?"/> <br/>
      <form v-on:submit.prevent='newPost'>
      <input type="text" v-model="newPic.caption" placeholder="caption your photo" />
      <input type="submit"/>
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
        username: this.$store.state.user.username,
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
          console.log(this.$store.state.user.username);
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