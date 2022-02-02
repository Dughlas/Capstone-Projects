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
            console.log('Done uploading..: ', result);          }
        }).open();
     }
}
}
</script>

<style>

</style>