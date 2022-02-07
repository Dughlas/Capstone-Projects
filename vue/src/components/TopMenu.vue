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
            <router-link
              v-bind:to="{ name: 'Home' }"
              tag="i"
              class="fa fa-home"
            ></router-link>
            
          </a>
      <a href="" class="navigation-link">
                  <router-link v-bind:to="{ name: 'uploadPhoto' }" tag='i' class='fa fa-plus-square'></router-link>
                </a>

          <a class="navigation-link notifica">
            <i class="far fa-heart">
              <div class="notification-bubble-wrapper">
                <div class="notification-bubble">
                  <span class="notifications-count">99</span>
                </div>
              </div>
            </i>
          </a>
          <a href="" class="navigation-link">
            <i class="far fa-user-circle"></i>
          </a>
          <a href="" id="signout" class="navigation-link">
            <i class="fas fa-sign-out-alt"></i>
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
        }
}
</script>

<style>

</style>