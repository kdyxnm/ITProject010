<template>
  <div class="list_containder">
    <h1> {{ this.title }}</h1>
    <div class="list_item_container">
    <!-- <img src="../assets/logo.png" alt=""> -->
      <div class="list_header_line" v-if="!isPhone">
        <div class="list_header">Medicine Name</div>
        <div class="list_header">Photo</div>
        <div class="list_header">quantity</div>
        <div class="list_header">Validity</div>
        <div class="list_header">Dosage</div>
      </div>
      <div class="desktop_list_warpper" v-if="!isPhone">
        <div class="medi_row" 
          v-for="medi_data in this.listData" 
          :key='medi_data.id'
          @click="goToMediDetail(medi_data.id)"  
        >
          <div class="medi_info">
            {{medi_data.brandname}}
          </div>
          <div class="medi_info">
            <div>
              <img class="medi_photo" :src="medi_data.image">
            </div>
          </div>
          <div class="medi_info">
            {{medi_data.quantity}} {{medi_data.quantitytype}}
          </div>
          <div class="medi_info">
            {{medi_data.validity}}
          </div>
          <div class="medi_info">
            {{medi_data.dosage}} {{medi_data.dosagetype}}
          </div>
        </div>
      </div>

      <div class="phone_list_warpper" v-if="isPhone">
        <div 
          class="medi_row" 
          v-for="medi_data in this.listData" 
          :key='medi_data.id' 
          @click="goToMediDetail(medi_data.id)"
        >
          <div class="medi_info_left">
            {{medi_data.brandname}}
            <div>
              <img class="medi_photo" :src="medi_data.image">
            </div>
          </div>

          <div class="medi_info_right">
            <table>
              <tr>
                <td style="text-align=left">
                  Quantity : 
                </td>
                <td style="text-align=right">
                  {{medi_data.quantity}} {{medi_data.quantitytype}}
                </td>
              </tr>
              <tr>
                <td style="text-align=left">
                  Validity : 
                </td>
                <td style="text-align=right">
                  {{medi_data.validity}}
                </td>
              </tr>
              <tr>
                <td style="text-align=left">
                  Dosage : 
                </td>
                <td style="text-align=right">
                  {{medi_data.dosage}} {{medi_data.dosagetype}}
                </td>
              
              </tr>
            </table>

          </div>
        </div>
      </div>

    </div>



    <div class="page_select_bar" v-if="!isSearchResult">
      <MedicineListPagination :total = "this.total" :pagesize = "pagesize" :page="this.page" :totalPages = "this.totalPages" @change = "changePage" />
    </div>
  </div>
</template>


<script>
import MedicineListPagination from './MedicineListPagination.vue';
import api from '../api/index'





export default {
    name: "MedicineList",
    data() {
        return {
        // display_flag : true,
        // isPhone : true,
        pagesize : 5,
        page : 1,
        totalPages : Math.ceil(this.total/this.pagesize),
        title : "My Medicines",
        // listData:null,
        listData : [
          {
            id: 1,
            brandname: "Norvasc" + 1,
            image: require("../assets/logo.png"),
            quantity: 2,
            validity: "03/08/2022",
            dosage: 3,
            dosagetype: "pills",
            quantitytype: "bottles",
          },
          {
            id: 2,
            brandname: "Norvasc" + 2,
            image: require("../assets/logo.png"),
            quantity: 3,
            validity: "03/08/2022",
            dosage: 4,
            dosagetype: "pills",
            quantitytype: "bottles",
          },
          {
            id: 3,
            brandname: "Norvasc" + 3,
            image: require("../assets/logo.png"),
            quantity: 3,
            validity: "03/08/2022",
            dosage: 4,
            dosagetype: "drops",
            quantitytype: "boxes",
          },
          {
            id: 4,
            brandname: "Norvasc" + 4,
            image: require("../assets/logo.png"),
            quantity: 3,
            validity: "03/08/2022",
            dosage: 4,
            dosagetype: "capsules",
            quantitytype: "packs",
          },
          {
            id: 5,
            brandname: "Norvasc" + 5,
            image: require("../assets/logo.png"),
            quantity: 3,
            validity: "03/08/2022",
            dosage: 4,
            dosagetype: "capsules",
            quantitytype: "packs",
          }
        ]
        }
    },
    props:{
      total: {
        type: Number,
        default: 0,
      },
      isSearchResult:{
        type: Boolean,
        default : false,
      },
      searchResult : {
        type : Object,
        default : null,
      }
    },
    
    components: { 
      MedicineListPagination 
    },
    created(){
      if(this.isSearchResult){
        console.log("Display Search Result")
        this.title = "Search Result"
        this.listData = this.searchResult
      }
      else{
        console.log("Getting pagination data")
        this.getPageData(1, this.pagesize)
      }

    },
    beforeMount(){
      this.isPhone = !(window.innerWidth > 992);
    },
    methods: {
      changePage(page, pagesize) {
         var _page = this.page,
             _pagesize = this.pagesize;
        this.page = page;
        this.pagesize = pagesize;
        if (page !== _page && pagesize || _pagesize !== pagesize){
          console.log("get list data")
          this.getPageData(page, pagesize)
        } 
      },

      getPageData(curPage, pageSize){
        console.log("Getting page " + curPage + " data")
        var that = this
        api.getPageData(curPage, pageSize).then(res => {
          console.log("Pagination data received")
          console.log(res.data)
          that.listData = res.data.data.records
        })
      },


      goToMediDetail(id){
        var mode = {
          view : 'medi_info',
          mediId : id
        }
        this.$emit("switch-event", mode)
      },


  }



}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap');

* {
  font-family: "Poppins", sans-serif;
}

@media screen and (max-width: 992px){   
  list_item_container{
    width: 100%;
    padding: 2em;
  }

  .medi_photo{
    width: 5em;
    height: 5em;
  }
  

  .medi_row{
    width: 100%;
    display: flex;
    align-items: center;
    margin-top: 1em;
    margin-bottom: 1em;
    border: 1px solid #dadcf4;
    border-radius: 1.5em;
    background-color: #f2f6ff;
    box-shadow: 2px 2px 2px #b8cbdd;
    font-size: 1em;
  }

  .medi_row:hover{
    background-color: #dfe8fc;
    box-shadow: 5px 5px 5px #a9bfd3
  }
  
  .medi_info_left{
    width: 50%;
    height: 100%;
    text-align: left;
    font-size: 1em;
    color: #3082CC;
    padding-left: 1em;
    font-weight: 600;
  }
  .medi_info_right{
    width: 50%;
    height: 100%;
    text-align: center;
    font-size: 0.8em;
    color : #3082CC;
  }

  .desktop_list_warpper{
    margin: 0;
    padding: 0;
    border: 0;
    width: 100%;
  }
}






@media screen and (min-width: 992px){   
  list_item_container{
    width: 100%;
    padding: 2em;
  }

  .medi_photo{
    width: 5em;
    height: 5em;
  }
  
  .list_header_line{
    width: 100%;
    display: flex;
    text-align: center;
  }

  .list_header{
    width : 20%;
    font-size: 1.3em;
    color: #6E78F7;
    font-weight: 600;
  }

  .medi_row{
    width: 100%;
    display: flex;
    align-items: center;
    margin-top: 1em;
    margin-bottom: 1em;
    border: 1px solid #dadcf4;
    border-radius: 1.5em;
    background-color: #f2f6ff;
    box-shadow: 2px 2px 2px #b8cbdd
  }

  .medi_row:hover{
    background-color: #dfe8fc;
    box-shadow: 5px 5px 5px #a9bfd3
  }
  
  .medi_info{
    width: 20%;
    height: 100%;
    text-align: center;
  }
}

</style>