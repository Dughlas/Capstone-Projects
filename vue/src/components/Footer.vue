<template>
  <div>
      <footer class="text-center bg-light">
      <!-- Grid container -->
      <div class="container pt-4">
        <!-- Section: simple footer links -->
        <section class="mb-4">
          <a href="#!" class="text-dark">{{message}}</a> &nbsp;&nbsp; 
          <!-- <a href="#!" class="text-dark">{{message1}}</a> &nbsp;&nbsp; |
          <a href="#!" class="text-dark">{{message2}}</a> -->
        </section>
        <!-- Section: Simple footer links -->
      </div>
      <!-- Grid container -->

      <!-- Copyright Footer -->
      <div class="text-center p-3">
        &copy; TE-gram.com
      </div>
      <!-- Copyright Footer-->
    </footer>
  </div>
</template>

<script>
export default {
        name: 'footer-section',

        data(){
            return {
                message:'About',
                message1:'Disclaimer',
                message2:'Privacy Policy'
            }
        }
    
}
</script>

<style>

</style>