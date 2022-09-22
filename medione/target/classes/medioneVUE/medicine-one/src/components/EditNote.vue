<template>
  <el-skeleton :rows="5" animated />

  <div style="margin: 20px 0"></div>
  <el-input
    v-model="textarea"
    maxlength="30"
    placeholder="Please input"
    show-word-limit
    type="textarea"
  />
</template>

<script>
export default {
  data() {
    return {
      textarea: ''
      

    }
  },


}

</script>

<style>

</style>