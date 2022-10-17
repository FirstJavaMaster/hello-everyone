<template>
  <h1>Todo List</h1>
  <h5>{{ num }}</h5>
  <el-button type="primary" plain @click="click">Click</el-button>
</template>

<script>
import {ref} from "vue";

export default {
  name: "TodoList",
  setup() {
    const num = ref(0)
    const click = () => {
      num.value++;
      console.log(num.value)
    }
    return {num: num, click: click}
  }
}
</script>

<style scoped>

</style>