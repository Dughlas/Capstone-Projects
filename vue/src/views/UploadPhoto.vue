<template>
  <div>
      <button @click="openUploadModal">Upload files</button>
</div>
</template>

<script>


export default {
  name: 'App',
  components: {
    
  },
  data() {
    return {
      url: '',
    }
  },
  mounted() {

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
            const upload = result.info;
            console.table(upload);  
            const url = upload.secure_url;
            console.log(url);
            //route to caption form 
            this.$router.push({ name: 'captionPhoto', query: { redirect: '/captionPhoto' }})
            }
        }).open();

        
     }
}
}
</script>

<style>

</style>