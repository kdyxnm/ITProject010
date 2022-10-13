<template>
  <div class="add_medi">
    <el-form :model="form" :label-width="this.formWidth" class="add_medi_form">
      <el-form-item label="Name">
        <el-input v-model="form.brandname" @blur="getFDAInfo(form.brandname)"/>
      </el-form-item>
      <el-form-item label="Location">
        <el-select v-model="form.locationid" placeholder="select storage locations">
          <el-option v-for="loc in this.locations" :key="loc" :label=loc.address :value=loc.locationid />
        </el-select>
      </el-form-item>
      <el-form-item label="Used by">
          <el-date-picker
            v-model="form.expire"
            type="date"
            placeholder="DD/MM/YYYY"
            format="DD/MM/YYYY"
            :style="this.isPhone ? 'width : 70%' : 'width : 60%'"
          />
      </el-form-item>
      <el-form-item label="Quantitiy">
        <el-input v-model="form.quantity" class="quant_dosage_item" />
        <el-select v-model="form.quantitytype" placeholder="select unit">
          <el-option label="Pills" value="Pills" />
          <el-option label="Capsules" value="Capsules" />
          <el-option label="Drops" value="Drops" />
          <el-option label="Patches" value="Patches" />
          <el-option label="Bags" value="Bags" />
          <el-option label="Bottles" value="Bottles" />
          <el-option label="Tubes" value="Tubes" />
          <el-option label="g" value="g" />
          <el-option label="ml" value="ml" />

        </el-select>
      </el-form-item>
      <el-form-item label="Dosage">
        <el-input v-model="form.dosage" class="quant_dosage_item" />
        <el-select v-model="form.dosagetype" placeholder="select unit">
          <el-option label="Pills" value="Pills" />
          <el-option label="Capsules" value="Capsules" />
          <el-option label="Drops" value="Drops" />
          <el-option label="Patches" value="Patches" />
          <el-option label="Bags" value="Bags" />
          <el-option label="Bottles" value="Bottles" />
          <el-option label="Tubes" value="Tubes" />
          <el-option label="g" value="g" />
          <el-option label="ml" value="ml" />
        </el-select>
      </el-form-item>
      <el-form-item label="Note">
        <el-input v-model="mediNote" type="textarea" class="note_text_area"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addPhoto()">Add Photo</el-button>
        <el-button>Cancel</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">Add Medicine</el-button>
        <el-button>Cancel</el-button>
      </el-form-item>
    </el-form>
    <div class="FDA_info">
      <DetailDescription :detailInfo="this.form" :key="this.FDAResult"></DetailDescription>
    </div>
  </div>
  
</template>

<script>
import store from '../store/index'
import api from '../api/index'
import DetailDescription from './DetailDescription.vue'
import { nil } from 'ajv';
import { thisTypeAnnotation } from '@babel/types';

export default {
    name: "AddMedicine",
    data() {
        return {
            isPhone: false,
            formWidth: "13%",
            locations: [],
            form: {
                id: -1,
                brandname: "",
                image: "",
                quantity: "",
                validity: "",
                dosage: "",
                dosagetype: "",
                quantitytype: "",
                manufacturername: "",
                genericname: "",
                producttype: "",
                route: "",
                description: "",
                usage: "",
                warnings: "",
                contraindications: "",
                adversereaction: "",
                overdosage: "",
                username: "",
                locationid: ""
            },
            mediNote: "",
            FDAResult: null,
        };
    },
    props: {},
    methods: {
        onSubmit() {
            console.log(this.form);
        },
        getFDAInfo(brandname) {
            console.log("User entered " + brandname);
            var name = brandname.toUpperCase();
            var that = this
            if (name !== "") {
                api.getFDAData(name).then(res => {
                    console.log(res.data);
                    that.FDAResult = res.data.results[0]
                    that.form.manufacturername = that.FDAResult.openfda.manufacturer_name[0]
                    that.form.genericname = that.FDAResult.openfda.generic_name[0]
                    that.form.producttype = that.FDAResult.openfda.product_type[0]
                    that.form.route = that.FDAResult.openfda.route[0]
                    that.form.description = that.FDAResult.description[0]
                    that.form.usage = that.FDAResult.indications_and_usage[0]
                    that.form.warnings = that.FDAResult.warnings_and_cautions[0]
                    that.form.contraindications = that.FDAResult.contraindications[0]
                    that.form.adversereaction = that.FDAResult.adverse_reactions[0]
                    that.form.overdosage = that.FDAResult.overdosage[0]

                });
            }
            else {
                console.log("No input");
            }
        },
    },
    created() {
        this.isPhone = !(window.innerWidth > 992);
        this.locations = store.getters.getLocations;
        if (this.isPhone) {
            this.formWidth = "22%";
        }
        this.form.username = store.getters.getUserName
    },
    components: { DetailDescription }
}

</script>

<style scoped>
  *{
    font-family: Tahoma, sans-serif;
  }
  .add_medi_form{
    width : 100%;
  }

  .add_medi_form :deep(.el-form-item__content) {
    flex-wrap: inherit;
  }




  @media screen and (max-width: 992px){
    .add_medi_form :deep(.el-form-item__label) {
      font-weight: 900;
      color: #6E78F7;
    }
    .quant_dosage_item{
      width: 40%;
      margin-right: 1em;
    }

    .note_text_area :deep(.el-textarea__inner){
      border-radius: 1em;
      box-shadow: 2px 2px 2px #b8cbdd;
      height: 5em;
    }
  }




  @media screen and (min-width: 992px){
    .add_medi_form{
      width: 45%;
      padding: 2em;
      border-radius: 2em;
      margin-right: 2em;
      box-shadow: 5px 5px 5px 5px #b8cbdd;
      height: 50%;
    }

    .FDA_info{
      width: 45%;
      border-radius: 2em;
      margin-right: 2em;
      box-shadow: 5px 5px 5px 5px #b8cbdd;
      padding-top: 2em;
      padding-left: 1em;
      padding-right: 1em;
      padding-bottom: 2em;
      height: 100%;
    }
    
    .add_medi{
      display: flex;
    }

    .add_medi_form :deep(.el-form-item__label) {
      font-size: 0.9em;
      font-weight: 900;
      color: #6E78F7;
    }
    .quant_dosage_item{
      width: 20%;
    }
    .note_text_area :deep(.el-textarea__inner){
      border-radius: 1em;
      box-shadow: 2px 2px 2px #b8cbdd;
      height: 5em;
    }
  }
  
</style>