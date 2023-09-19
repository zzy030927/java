import Vue from 'vue'
import VueRouter from 'vue-router'
import EmpView from "@/views/tlias/EmpView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/emp',
    name: 'emp',
    component: EmpView   // ���ļ���ͷ�Ѿ�����
  },
  {
    path: '/dept',
    name: 'dept',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/tlias/DeptView.vue')
  },
  {
    path: '/',           // ����Ĭ�Ϸ��ʵ�·��
    redirect: '/emp'
  }
]

const router = new VueRouter({
  routes
})

export default router
