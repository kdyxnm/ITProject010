/**
/*
* 
* @description: This component contains add medicine page function,
*               function include add medicine, upload image, show medicine details
* @author: Yuchen Cao
* @update: Yuchen Cao (2022-11-3 10:14)
*
*/

<template>
  <div class="add_medi">
    <el-form :model="form" :label-width="this.formWidth" class="add_medi_form">
      <el-form-item label="Name">
        <el-input v-model="form.brandname" @blur="getFDAInfo(form.brandname)"/>
      </el-form-item>
      <el-popover
        placement="top-start"
        title="Location not on the list?"
        :width="280"
        trigger="hover"
        content="Adding a location in My Location."
      >
        <template #reference>
          <el-form-item label="Location">
            <el-select v-model="form.locationid" placeholder="select storage locations">
              <el-option v-for="loc in this.locations" :key="loc" :label=loc.address :value=loc.locationid />
            </el-select>
          </el-form-item>
        </template>
      </el-popover>
      <el-form-item label="Used by">
          <el-date-picker
            v-model="form.validity"
            type="date"
            placeholder="DD/MM/YYYY"
            format="DD/MM/YYYY"
            :style="this.isPhone ? 'width : 70%' : 'width : 60%'"
          />
      </el-form-item>
      <el-form-item label="Quantitiy">
        <el-input v-model="form.quantity" class="quant_dosage_item" />
        <el-select v-model="form.quantitytype" placeholder="select unit">
          <el-option label="Unit" value="Unit " />
          <el-option label="Boxes" value="Boxes " />
          <el-option label="Bags" value="Bags " />
          <el-option label="Bottles" value="Bottles " />
          <el-option label="Tubes" value="Tubes " />
          <el-option label="Packages" value="Packages " />

        </el-select>
      </el-form-item>
      <el-form-item label="Dosage" class="doage_item">
        <el-input v-model="form.dosage" class="quant_dosage_item" />
        <el-select v-model="form.dosagetype" placeholder="select unit">
          <el-option label="Pills" value="Pills " />
          <el-option label="Capsules" value="Capsules " />
          <el-option label="Drops" value="Drops " />
          <el-option label="Patches" value="Patches " />
          <el-option label="Bags" value="Bags " />
          <el-option label="Bottles" value="Bottles " />
          <el-option label="Tubes" value="Tubes " />
          <el-option label="g" value="g " />
          <el-option label="ml" value="ml " />
        </el-select>
        <el-select v-model="dosageFreq" placeholder="select frequency">
          <el-option label="1 times per day" value="1 times per day" />
          <el-option label="2 times per day" value="2 times per day" />
          <el-option label="3 times per day" value="3 times per day" />
          <el-option label="4 times per day" value="4 times per day" />
          <el-option label="When needed" value="When needed" />
          <el-option label="Emergency" value="Emergency" />
          <el-option label="Every 12 hour" value="Every 12 hour" />
          <el-option label="Every 2 hour" value="Every 2 hour" />
          <el-option label="Every 4 hour" value="Every 4 hour" />
          <el-option label="Every 6 hour" value="Every 6 hour" />
          <el-option label="Every 8 hour" value="Every 8 hour" />
          <el-option label="Every 10 hour" value="Every 10 hour" />
          <el-option label="Every 12 hour" value="Every 12 hour" />
        </el-select>
      </el-form-item>
      <el-form-item label="Note">
        <el-input v-model="mediNote" type="textarea" class="note_text_area"/>
      </el-form-item>
      <el-form-item style="display=block" label="Photo">
        <UploadImage @uploaded="handleImageUpload" @removed="handleImageRemoved(file)"></UploadImage>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">Add Medicine</el-button>
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
import { ref } from 'vue'
import UploadImage from './UploadImage.vue'

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
          dosageFreq : "",
      };
  },
  props: {},
  methods: {
      onSubmit() {
        var validFlag = this.isFormValid(this.form)
        if(validFlag.type === "error"){
          ElNotification.error(validFlag.msg)
          return null
        } else if(validFlag.type === "warning"){
          ElNotification({
                      message: validFlag.msg,
                      type: 'warning',
          })
        }

        this.form.dosagetype = this.form.dosagetype + this.dosageFreq
        this.form.validity = this.form.validity.toLocaleDateString('en-GB')
        console.log("Medicine Information")
        console.log(this.form);
        var that = this
        api.addMedicine(this.form).then(res => {
          console.log(res)
          if(res.data.status === 200){
            if(that.mediNote !== ""){
              that.addNote(res.data.data)
            }

            ElNotification({
                      message: 'SUCCESS',
                      type: 'success',
            })
            that.triggerUpdate()
          }
        })
      },

      addNote(id){
        console.log("id : " + id)
        console.log(this.mediNote)
        api.addMediNote(id, this.mediNote)
      },

      triggerUpdate(){
        this.$emit("medicine-updated")
        this.backtoDashboard()
      },

      backtoDashboard(){
        console.log("back to dashboard triggered")
        var mode = {
          view : 'default',
        }
        this.$emit("switch-event", mode)
		  },

      isFormValid(form){
        var results = {
          state : true,
          msg : "Valid form",
          type : "success"
        }
        if(form.brandname.length <= 0){
          results.state = false,
          results.msg = "Brand name missing"
          results.type = "error"
          return results
        }
        if(form.validity === ""){
          results.state = false,
          results.msg = "Expiration date missing"
          results.type = "error"
          return results
        }
        if(form.quantity === ""){
          results.state = false,
          results.msg = "Quantity missing"
          results.type = "error"
          return results
        }
        if(form.quantitytype === ""){
          results.state = false,
          results.msg = "Quantity Unit missing"
          results.type = "error"
          return results
        }
        if(form.dosage === ""){
          results.state = false,
          results.msg = "Dosage missing"
          results.type = "error"
          return results
        }
        if(form.dosagetype === ""){
          results.state = false,
          results.msg = "Dosage Unit missing"
          results.type = "error"
          return results
        }
        if(this.dosageFreq === ""){
          results.state = false,
          results.msg = "Dosage frequency missing"
          results.type = "error"
          return results
        }          
        if(form.locations === ""){
          results.state = false,
          results.msg = "Location missing"
          results.type = "warning"
          return results
        }
        if(form.image === ""){
          results.state = false,
          results.msg = "Image missing"
          results.type = "warning"
          return results
        }
        return results
      },

      getFDAInfo(brandname) {
          console.log("User entered " + brandname);
          var name = brandname.toUpperCase();
          var that = this
          if (name !== "") {
              api.getFDAData(name).then((res) => {
                  console.log(res.data);


                  try{
                    that.FDAResult = res.data.results[0]
                  } catch (e){
                    console.error(e)
                  }
                  // that.FDAResult = res.data.results[0]


                  try{
                    that.form.manufacturername = that.FDAResult.openfda.manufacturer_name[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.manufacturername = that.FDAResult.openfda.manufacturer_name[0]


                  try{
                    that.form.genericname = that.FDAResult.openfda.generic_name[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.genericname = that.FDAResult.openfda.generic_name[0]


                  try{
                    that.form.producttype = that.FDAResult.openfda.product_type[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.producttype = that.FDAResult.openfda.product_type[0]


                  try{
                    that.form.route = that.FDAResult.openfda.route[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.route = that.FDAResult.openfda.route[0]


                  try{
                    that.form.description = that.FDAResult.description[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.description = that.FDAResult.description[0]


                  try{
                    that.form.usage = that.FDAResult.indications_and_usage[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.usage = that.FDAResult.indications_and_usage[0]


                  try{
                    that.form.warnings = that.FDAResult.warnings_and_cautions[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.warnings = that.FDAResult.warnings_and_cautions[0]


                  try{
                    that.form.contraindications = that.FDAResult.contraindications[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.contraindications = that.FDAResult.contraindications[0]


                  try{
                    that.form.adversereaction = that.FDAResult.adverse_reactions[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.adversereaction = that.FDAResult.adverse_reactions[0]


                  try{
                    that.form.overdosage = that.FDAResult.overdosage[0]
                  } catch (e){
                    console.error(e)
                  }
                  //that.form.overdosage = that.FDAResult.overdosage[0]
                  ElNotification({
                            message: "Extra information is ready",
                            type: 'success',
                          })
              },
              ()=>{
                console.log("Medicine Name Not Found")
                ElNotification({
                            message: "No extra information found",
                            type: 'warning',
                          })
              });
          }
          else {
              console.log("No input");
          }
      },
      handleImageUpload(url){
        console.log("Image URL is " + url)
        this.form.image = url
      },
      handleImageRemoved(file){
        console.log("Image deleted")
        this.form.image = ""
      }
  },
  created() {
      this.isPhone = !(window.innerWidth > 992);
      this.locations = store.getters.getLocations;
      if (this.isPhone) {
          this.formWidth = "22%";
      }
      this.form.username = store.getters.getUserName
  },
  components: { DetailDescription, UploadImage }
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

    .FDA_info{
      margin-top: 2em;
    }
    
    .doage_item :deep(.el-form-item__content){
      display: block;
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