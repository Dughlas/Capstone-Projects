<template>
  <div>
    <span>
      <button>
        <i
          class="far fa-thumbs-up"
          data-fa-transform="shrink-10 up-.5"
          data-fa-mask="fas fa-comment"
        ></i></button
    ></span>
    <span>
      <button>
        <i
          class="far fa-heart"
          data-fa-transform="shrink-3.5 down-1.6 right-1.25"
          data-fa-mask="fas fa-circle"
        ></i>
      </button>
    </span>
  </div>
</template>

<script>
export default {
  name: "buttons",
};
</script>

<style>
span {
  padding: 0px 15px;
}
button {
  padding: 0;
  border: none;
  background: none;
}
</style>