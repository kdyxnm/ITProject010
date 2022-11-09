/**
/*
* 
* @description: This component contains medicine detail description,
*               medicine detail description obtain from external database 
* @author: Tianjin zhao
* @update: Tianjin zhao(2022-11-8 19:14)
*
*/

<template>
  <div class="demo-collapse">
    <el-collapse v-model="activeName" accordion>
      <el-collapse-item title="Manufacturer Name:" name="1">
        <div>
          {{this.detailInfo.manufacturername}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="Description:" name="2">
        <div>
          {{this.detailInfo.description}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="Indications and Usage:" name="3">
        <div>
          {{this.detailInfo.usage}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="Warnings:" name="4">
        <div>
          {{this.detailInfo.warnings}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="Contraindications:" name="5">
        <div>
          {{ this.detailInfo.contraindications}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="Adverse Reactions:" name="6">
        <div>
          {{ this.detailInfo.adversereaction}}
        </div>
      </el-collapse-item>
      <el-collapse-item title="Overdosage:" name="7">
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
      activeName : '1',
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
	},


}

</script>

<style>

.el-collapse-item__header {
  background-color: #ffffff00;
  font-size: 0.8em;
}

.el-collapse {
  --el-collapse-content-bg-color: #ffffff00;
  /* --el-collapse-border-color: #A5A3A3; */
}
</style>