<template>
<div>
    <user-page v-bind:to="userPictures" />
</div>

</template>

<script>
import serverService from "../services/ServerService.js";

export default {
    name: 'userPosts',
    props: ["selectedUser"],

      data() {
    return {
      userPictures: []
    }
  },

    created() {
serverService.listByUser(this.selectedUser).then((response) => {
        console.log(response.data);
        this.pictures = response.data;
      });
    }
}

</script>

<style>
.box{
    padding: 150px;
}

</style>