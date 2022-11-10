/**
/*
* 
* @description: This component contains medicine list pagination function in the dashboard view
* @author: Yuchen Cao
* @update: Yuchen Cao (2022-11-4 11:16)
*
*/

<template>
  <div class = " flex all-center">
    <template v-if="total > 0">
      <el-pagination
        :hide-on-single-page="true" 
        :page-size="pagesize"
        :total="total"
        :current-page="page"
        background
        layout="prev, pager, next"
        class="my-pagination"
        @current-change="changePage" />
    </template>
  </div>
</template>

<script>
export default {
  name: 'MedicineListPagination',
  props: {
    total: {
      type: Number,
      default: 20,
    },
    page: {
      type: Number,
      default: 1,
    },
    pagesize: {
      type: Number,
      default: 10,
    },
    totalPages: {
      type: Number,
      default: 1,
    },
  },
  created() {
    this.getCurrentPage();
  },
  methods: {
    changePage(val) {
      this.handlePage('push', val, this.pagesize);
      this.$emit('change', val, this.pagesize);
    },
    getCurrentPage() {
      var { page, pagesize } = this.$route.query;
      if (!page || !pagesize) {
        this.handlePage('replace', page || 1, +pagesize || this.pagesize);
        return true;
      }
      return false;
    },
    handlePage(type, page, pagesize) {
      this.$router[type]({
        path: this.$route.path,
        query: { ...this.$route.query, page, pagesize },
      });
    }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.my-pagination {
  padding-top: 0;  
}
</style>
