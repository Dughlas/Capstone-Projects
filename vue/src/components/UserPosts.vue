<template>
  <div>
      <input type="text"  v-model='user.id' />
        {{this.user}}
      

  </div>
</template>

<script>
import ServerService from '../services/ServerService.js';
export default {
    created(){
        const userId = this.$route.params.userId;
        ServerService.getUserPics(userId).then(
            (response) => {
                this.user = response.data;
            }
        )
    }

}
</script>

<style>

</style>