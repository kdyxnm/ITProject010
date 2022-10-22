<template>
  <el-autocomplete
    v-model="state"
    :fetch-suggestions="querySearch"
    popper-class="my-autocomplete"
    placeholder="Search Medicine"
    @select="handleSelect"
  >
    <template #suffix>
      <el-icon class="el-input__icon" @click="handleIconClick">
        <Search />
      </el-icon>
    </template>
    <template #default="{ item }">
      <div class="value">{{ item.value }}</div>
      <span class="link">{{ item.link }}</span>
    </template> 
  </el-autocomplete>
</template>

<script>
/* Analyzed bindings: {
  "onMounted": "setup-const",
  "ref": "setup-const",
  "Edit": "setup-maybe-ref",
  "state": "setup-ref",
  "links": "setup-ref",
  "querySearch": "setup-const",
  "createFilter": "setup-const",
  "loadAll": "setup-const",
  "handleSelect": "setup-const",
  "handleIconClick": "setup-const"
} */
import { defineComponent as _defineComponent } from 'vue'
import { unref as _unref,
        createVNode as _createVNode,
        resolveComponent as _resolveComponent,
        withCtx as _withCtx,
        toDisplayString as _toDisplayString,
        createElementVNode as _createElementVNode,
        openBlock as _openBlock,
        createBlock as _createBlock } from "vue"

const _hoisted_1 = { class: "value" }
const _hoisted_2 = { class: "link" }

import { onMounted, ref } from 'vue'
import { Search } from '@element-plus/icons-vue'
import store from '../store/index'
import api from '../api/index'

const __sfc__ = /*#__PURE__*/_defineComponent({
  __name: 'Sidebar',

  setup(__props, __context) {
    const state = ref('')
    const links = ref([])

    const querySearch = (queryString, cb) => {
      const results = queryString
        ? links.value.filter(createFilter(queryString))
        : links.value
      // call callback function to return suggestion objects
      cb(results)
    }

    const createFilter = (queryString) => {
      return (restaurant) => {
        return (
          restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0
        )
      }
    }

    const loadAll = () => {
      console.log("Get Data for auto complete")
      // console.log(store.getters.getAutoCompleteData)
      return store.getters.getAutoCompleteData
      // return [
      //   { value: 'aa drug1', link: "home" },
      //   { value: 'bb drug1', link: "office" },
      //   { value: 'cc drug1', link: "parents" },
      //   { value: 'dd drug1', link: "home" },
      //   { value: 'ee drug1', link: "office" },
      //   { value: 'ff drug1', link: "no location" },
      //   { value: 'gg drug1', link: "nonono location" },
      // ]
    }

    
    const handleSelect = (item) => {
      console.log("Accurate Search")
      console.log(item)
      var location = item.link;
      if(location === ''){
        location = null
      }

      var locId = null;

      // get location id
      var locationmap = store.getters.getLocationMap;
      console.log(locationmap.length)
      for(var i=0 ; i < locationmap.length; i++){
        console.log(locationmap[i].address)
        if(locationmap[i].address === location){
          console.log('loc match ' + locationmap[i].locationid)
          locId = locationmap[i].locationid
          break;
        }
      }

      var id = null;
      var mediList = store.getters.getUserData
      for(var i=0 ; i < store.getters.getNumMedi ; i++){
        if(mediList[i].brandname == item.value
          && mediList[i].locationid == locId){
            console.log('medicine match')
            id = mediList[i].id;
            break;
          }
      }

      if(id != null){
        //__context.emit("refresh")
        var mode = {
          view : 'medi_info',
          mediId : id
        }
        __context.emit("switch-event", mode)
      }
      else{
        console.log("user data corrucped")
      }

      state.value = ""
    }


    const handleIconClick = (ev) => {
      console.log(state.value)
      console.log("Blurry Search Request")
      api.blurrySearch(state.value).then(res => {
        console.log("Blurry Request Success")
        console.log(res.data)
        //__context.emit("refresh")
        var mode = {
          view : 'search_result',
          results : res.data.data
        }
        __context.emit("switch-event", mode)
      })
      state.value = ""
    }


    onMounted(() => {
      links.value = loadAll()
    })


    return (_ctx,_cache) => {
      const _component_el_icon = _resolveComponent("el-icon")
      const _component_el_autocomplete = _resolveComponent("el-autocomplete")

      return (_openBlock(), _createBlock(_component_el_autocomplete, {
        modelValue: state.value,
        "onUpdate:modelValue": _cache[0] || (_cache[0] = ($event) => ((state).value = $event)),
        "fetch-suggestions": querySearch,
        "popper-class": "my-autocomplete",
        placeholder: "Please input",
        onSelect: handleSelect
      }, 
      {
        suffix: _withCtx(() => [
            _createVNode(_component_el_icon, {
              class: "el-input__icon",
              onClick: handleIconClick
            }, {
              default: _withCtx(() => [
                _createVNode(_unref(Search))
            ]),
            _: 1 /* STABLE */
            })
          ]),

        default: _withCtx(({ item }) => [
          _createElementVNode("div", _hoisted_1, _toDisplayString(item.value), 1 /* TEXT */),
          _createElementVNode("span", _hoisted_2, _toDisplayString(item.link), 1 /* TEXT */)
        ]),
        _: 1 /* STABLE */
      }, 8 /* PROPS */, ["modelValue"]))
    }
}

})
__sfc__.__file = "SideBar.vue"
export default __sfc__
</script>
<style scoped>
  *{
    font-family: "Gill Sans", sans-serif;
  }
</style>


<style>
  .my-autocomplete li {
    line-height: normal;
    padding: 1em;
    font-size: 1.2em;
  }

  .my-autocomplete li :hover{
    margin-left: 15px;
  }

  .my-autocomplete li .name {
    text-overflow: ellipsis;
    overflow: hidden;
  }
  .my-autocomplete li .addr {
    font-size: 12px;
    color: #b4b4b4;
  }
  .my-autocomplete li .highlighted .addr {
    color: #ddd;
  }

  .value{
    font-size: 1.15em;
    font-weight: 500;
    color: #6E78F7;
  }
  
  .link{
    font-size: 0.8em;
    color: #752bb5;
  }

  .el-autocomplete-suggestion{
    display: felx;
  }

  @media  screen and (max-width: 992px) {
    .el-autocomplete.el-tooltip__trigger.el-tooltip__trigger {
      width: 100%;
      height: 100%;
    }
    .el-input.el-input--suffix {
      width: 100%;
      font-size: 1.2em;
      height: 100%;
      font-weight: 600;
    }
    .el-input__wrapper {
      align-items: center;
      height: 100%;
      border-radius: 2em;
      box-shadow: 2px 2px 2px #b8cbdd;
    }
    .el-input__wrapper:hover {
      background-color:#eaeaea ;
    }
    span.el-input__suffix-inner {
      margin-right: 1em;
      color: #6E78F7;
    }
    span.el-input__suffix-inner :hover {
      color: #545bc3;
    }
  }
 
  
  @media screen and (min-width: 992px) {
    .el-autocomplete.el-tooltip__trigger.el-tooltip__trigger {
      width: 100%;
      height: 100%;
    }
    .el-input.el-input--suffix {
      width: 100%;
      font-size: 1.5em;
      height: 100%;
      font-weight: 600;
      padding-right: 1em;
      padding-left: 1em;
    }
    .el-input__wrapper {
      border-radius: 2em;
      box-shadow: 3px 3px 3px #b8cbdd;
    }
    .el-input__wrapper:hover {
      background-color:#eaeaea ;
      box-shadow: 10px 10px 10px #b8cbdd;
    }
    span.el-input__suffix-inner {
      margin-right: 1em;
      color: #6E78F7;
    }
    span.el-input__suffix-inner :hover {
      color: #545bc3;
    }
    
  }
</style>
