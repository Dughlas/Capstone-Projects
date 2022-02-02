<template>
  <div class="home">
    <h1>TE-GRAM</h1>

    <nav>
      <router-link v-bind:to="{ name: 'uploadPhoto' }">Upload New Photo</router-link> <br/>
      <router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link>
    </nav>

    <p>Photo feed coming soon...</p>

    <!-- TODO:
    1. photo feed
    2. add photo button
    3. search users
    4. my profile 
     -->


  </div>
</template>

<script>
export default {
  name: "home",

  methods: {

  }
};
</script>
