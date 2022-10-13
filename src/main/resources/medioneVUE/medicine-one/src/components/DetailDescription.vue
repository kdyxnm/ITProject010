<template>
  <div class="demo-collapse">
    <el-collapse v-model="activeName" accordion>
      <el-collapse-item title="&nbsp Description:" name="1">
        <div>
          {{this.detailInfo.description}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="&nbsp Indications and Usage:" name="2">
        <div>
          {{this.detailInfo.usage}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="&nbsp Warnings:" name="3">
        <div>
          {{this.detailInfo.warnings}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="&nbsp Contraindications:" name="4">
        <div>
          {{ this.detailInfo.contraindications}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="&nbsp Adverse Reactions:" name="5">
        <div>
          {{ this.detailInfo.adversereaction}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="&nbsp Overdosage:" name="6">
        <div>
          {{ this.detailInfo.overdosage}}
        </div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>
<script>

export default {
  data() {
    return {
      activeName : '',
    }
  },
  props : {
		detailInfo : {
			type : Object,
			default : null,
		}
	},
  created(){
		console.log(this.detailInfo)
		// api.getMediInfo(this.mediId).then(res=>{
		// 	that.mediInfo = res.data.data
		// 	console.log(that.mediInfo)
		// 	that.isDataReady = true;
		// })
	},


}

</script>

<style>

.el-collapse-item__header {
  background-color: #ffffff00;
}


.el-collapse {
  --el-collapse-content-bg-color: #ffffff00;
}
</style>