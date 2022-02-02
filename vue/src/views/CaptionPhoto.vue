<template>
  <div>
      <!-- place photo thumbnail here -->
      <img v-bind:src="$store.state.upload.url" alt="photo thumbnail?"/> <br/>
      <input v-model="caption" placeholder="caption your photo">
  </div>
</template>

<script>
export default {
  data () {
    return {
      caption: ''
    }
  },

  created() {
    console.log(this.$store.state.upload.url)
  }
}
</script>

<style>

</style>