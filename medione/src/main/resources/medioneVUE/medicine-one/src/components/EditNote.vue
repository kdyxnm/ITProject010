<!-- <template>
  <el-skeleton :rows="5" animated />

  <div style="margin: 20px 0" />
  <el-input
    v-model="textarea"
    maxlength="30"
    placeholder="Please input"
    show-word-limit
    type="textarea"
  />
</template>

<script>
  /* Analyzed bindings: {
  "ref": "setup-const",
  "text": "setup-ref",
  "textarea": "setup-ref"
} */
import { defineComponent as _defineComponent } from 'vue'
import { resolveComponent as _resolveComponent, createVNode as _createVNode, createElementVNode as _createElementVNode, Fragment as _Fragment, openBlock as _openBlock, createElementBlock as _createElementBlock } from "vue"

const _hoisted_1 = /*#__PURE__*/_createElementVNode("div", { style: {"margin":"20px 0"} }, null, -1 /* HOISTED */)

import { ref } from 'vue'

const __sfc__ = /*#__PURE__*/_defineComponent({
  __name: 'App',
  setup(__props) {

const text = ref('')
const textarea = ref('')

return (_ctx,_cache) => {
  const _component_el_input = _resolveComponent("el-input")

  return (_openBlock(), _createElementBlock(_Fragment, null, [
    _createVNode(_component_el_input, {
      modelValue: text.value,
      "onUpdate:modelValue": _cache[0] || (_cache[0] = ($event) => ((text).value = $event)),
      maxlength: "10",
      placeholder: "Please input",
      "show-word-limit": "",
      type: "text"
    }, null, 8 /* PROPS */, ["modelValue"]),
    _hoisted_1,
    _createVNode(_component_el_input, {
      modelValue: textarea.value,
      "onUpdate:modelValue": _cache[1] || (_cache[1] = ($event) => ((textarea).value = $event)),
      maxlength: "30",
      placeholder: "Please input",
      "show-word-limit": "",
      type: "textarea"
    }, null, 8 /* PROPS */, ["modelValue"])
  ], 64 /* STABLE_FRAGMENT */))
}
}

})
__sfc__.__file = "App.vue"
export default __sfc__
</script>

<style>

</style> -->