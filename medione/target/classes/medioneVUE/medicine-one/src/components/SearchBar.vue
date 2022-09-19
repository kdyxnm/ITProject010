<template>
  <el-autocomplete
    v-model="state"
    :fetch-suggestions="querySearch"
    popper-class="my-autocomplete"
    placeholder="Please input"
    @select="handleSelect"
  >
    <template #suffix>
      <el-icon class="el-input__icon" @click="handleIconClick">
        <Search />
      </el-icon>
    </template>
    <template #default="{ item }">
      <div class="value">{{ item.value }}</div>
      <span class="link">{{ item.link }}</span> -->
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

const __sfc__ = /*#__PURE__*/_defineComponent({
  __name: 'Sidebar',

  setup(__props) {
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
      console.log("I could do some request here, haha")
      return [
        { value: 'aa drug1', link: "home" },
        { value: 'bb drug1', link: "office" },
        { value: 'cc drug1', link: "parents" },
        { value: 'dd drug1', link: "home" },
        { value: 'ee drug1', link: "office" },
        { value: 'ff drug1', link: "no location" },
        { value: 'gg drug1', link: "nonono location" },
      ]
    }


    const handleSelect = (item) => {
      console.log(item)
    }


    const handleIconClick = (ev) => {
      console.log(state._value)
      console.log("SearchRequest could do here")
      console.log(ev)
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



<style>
  .my-autocomplete li {
    line-height: normal;
    padding: 7px;
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
</style>
