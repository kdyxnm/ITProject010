<template>
  <div>
    <button @click="sendToFather">CLICK FOR TESTING</button>
  </div>
</template>

<script>
  export default {
  name: 'SomeCmponent',
  data() {
    return {
    }
  },
  methods: {
    sendToFather() {
      alert("click in child")
      this.$emit("open-side-bar-event", true)
    }
  }
}
</script>