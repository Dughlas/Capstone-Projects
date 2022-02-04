<template>

<div>
 <section>

      <div class="main-flex-container">
        <div class="flex-container">
          <div v-for="pic in allPictures" :key="pic.id">
            <p class="poster-name">{{ pic.username }}</p>

            <p><img :src="pic.url" width="300" length="300" alt="" /></p>

            <p class="caption">{{pic.caption}}</p>

            <p>
              <a class="navigation-link notifica">
                <i class="far fa-heart">
                  <div class="notification-bubble-wrapper">
                    <div class="notification-bubble">
                      <span class="notifications-count">99</span>
                    </div>
                  </div>
                </i>
              </a>
            </p>
          </div>
        </div>
      </div>
    </section>

    

</div>

    
</template>

<script>
import serverService from "../services/ServerService.js";

export default {
    name: "postcard-2",
    
     data() {
    return {
      pictures: [],
      allPictures: []
    };
  },
  created() {
    serverService.listByUser(this.$store.state.user.username).then(
      (response) => {
        console.log(response.data);
        this.pictures = response.data;
      },
      serverService.listAll().then((response) => {
        console.log(response.data);
        this.allPictures = response.data;
      })
    );
  },
}
</script>

<style>

.main-flex-container {
  display: flex;
  justify-content: center;
  background-color: rgb(245, 245, 240);
}

.flex-container > div {
  background-color: #f1f1f1;
  margin: 10px;
  padding: 20px;
  font-size: 30px;
}



</style>