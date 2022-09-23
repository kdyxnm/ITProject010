<template>
  <div class="overall_content">
    <!-- <el-skeleton :rows="3" animated /> -->

    <div style="margin: 20px 0">
      <el-input
        v-model="userNote"
        maxlength="50"
        placeholder="Please input"
        show-word-limit
        type="textarea"
      />
      
      <div class="submit_button">
        <input type="button" class="submitNote_button" value="submit" @click="submit_note">
      </div>
  </div>

  </div>
</template>

<script>
export default {
  data() {
    return {
      

    }
  },
  props : {
    userNote : {
      type : String,
      default : ''
    },
  }


}

</script>

<style scoped>
/* phone size */
@media screen and (max-width: 992px){   
  overall_content{
    width: 100%;
    padding: 2em;
  }

  .submit_button {
    margin-left: 15em;
  }

  .submitNote_button {
    width: 7em;
    height: 1.5em;
    background: #E5E9FD;
    color: #6E78F7;
    border-style: none;
    border-radius: 0.2em;
    -webkit-transition-duration: 0.5s; /* Safari */
    transition-duration: 0.5s;
  }
}

</style>