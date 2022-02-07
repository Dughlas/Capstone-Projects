<template>
  <div>
      <!-- class="navigation" -->
    <nav>
      <div class="navigation">
        <div class="logo">
          <a class="no-underline" href="#">{{message}}</a>
        </div>

        
        <br />
        <!-- <router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link> -->
        <div class="navigation-search-container">
          <i class="fa fa-search"></i>
          <input class="search-field" type="text" placeholder="Search" />
          <div class="search-container">
            <div class="search-container-box">
              <div class="search-results"></div>
            </div>
          </div>
        </div>
        <div class="navigation-icons">
          <a href="" target="_blank" class="navigation-link">
            <router-link v-bind:to="{ name: 'Home' }" tag="i" class="fa fa-home"></router-link>
          </a>

          <!-- Upload widget -->
           <!-- <a href="" class="navigation-link"> -->
             <!-- <i @click="openUploadModal" tag='i' class='fa fa-plus-square'></i> -->
             <button @click="openUploadModal" tag='i' class='fa fa-plus-square'></button>
          <!-- </a> -->

          <a class="navigation-link notifica">
            <i class="far fa-heart">
              <div class="notification-bubble-wrapper">
                <div class="notification-bubble">
                  <span class="notifications-count">99</span>
                </div>
              </div>
            </i>
          </a>

         <!-- Profile widget -->
          <a href="" class="navigation-link">
            <i class="far fa-user-circle"></i>
          </a>

            <!--Logout widget  -->
          <a href="" id="signout" class="navigation-link">
            <!-- <i class="fas fa-sign-out-alt"></i>  -->
              <router-link v-bind:to="{ name: 'logout' }" tag='i' class='fas fa-sign-out-alt'></router-link>  
          </a>


        </div>
      </div>
    </nav>

    <div>
      <div></div>
    </div>

  </div>
</template>

<script>
export default {
     name: 'top-menu',

        data(){
            return {
                message:'TE-gram',
                
            }
        },

        methods: {
    openUploadModal() {
      window.cloudinary.openUploadWidget(
        { cloud_name: 'te-gram2022',
          upload_preset: 'o1kxq5jo'
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log('Done uploading..: ', result);
            this.$store.state.upload = result.info;
            console.table(this.$store.state.upload);  
            const url = this.$store.state.upload.secure_url;
            console.log(url);
            this.$router.push({ name: 'captionPhoto', query: 
            { redirect: '/captionPhoto' }})
            }
        }).open();

        
     }
}

        
}
</script>

<style>

</style>