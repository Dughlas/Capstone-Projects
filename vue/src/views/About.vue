<template>
  <div>
    <top-menu></top-menu>
    <div class="flex-container">
      <div>About</div>
      <div>
        <p>TE-gram is a free photo and video sharing app available on iPhone and Android. 
          People can upload photos or videos to our service and share them with their followers or with a select group of friends. They can also view, comment and like posts shared by their friends on Instagram. 
          Anyone 13 and older can create an account by registering an email address and selecting a username.</p>
      </div>

    </div>
     <footer-section></footer-section>
  </div>
</template>

<script>
import TopMenu from "../components/TopMenu.vue";
  import FooterSection from "../components/Footer.vue";

export default {
    name: 'about',
    components: {
     TopMenu, 
    FooterSection
  },

}
</script>

<style>
.flex-container {
  display: flex;
  flex-direction: column;
 }

.flex-container > div {
  background-color: #f1f1f1;
  margin: 10px;
  padding: 20px;
  font-size: 30px;
}
</style>