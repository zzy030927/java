<template>
  <!--通过router-view把组件加载进来-->
  <router-view></router-view>
</template>

<script setup>
import AppHome from './components/app/AppHome.vue';
import AppIndex from './components/app/AppIndex.vue';
import TodoList from './components/app/ManagerCarList.vue';
import UserList from './components/app/UserList.vue';
import Login from './components/login/Login.vue';
import router from './router/myRouter.js';
/* export default {
  //选项式API
  name: 'App',
  components: {
    
  }
} */
</script>
