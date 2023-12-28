//定义全局路由: 页面组件之间的跳转逻辑关系
//导入vue-router函数
import { createWebHistory, createRouter } from 'vue-router'
//需要路由的页面组件,都需要导入,再定义路由关系
import Login from "../components/login/Login.vue"
import AppIndex from '../components/app/AppIndex.vue'
import AppHome from "../components/app/AppHome.vue"
import Cars from "../components/app/ManagerCarList.vue"
import userList from "../components/app/userList.vue"
import userInfo from "../components/app/UserInfo.vue";
import carInfo from "../components/app/CarInfo.vue";
import Employee from "../components/app/Employee.vue";
//创建路由管理器
const router = createRouter({
    history: createWebHistory(),// 路由模式
    routes: [
        {
            path: '/', //浏览器访问 / 时,重定向到/login
            redirect: 'login'
        },
        {//所有的组件要跳转，必须先命名路由
            path: '/login', //访问的url
            name: 'login',
            component: Login //页面组件名称
        },
        {//所有的组件要跳转，必须先命名路由
            path: '/app/index',
            name: 'appindex',
            component: AppIndex,
            children: [//appindex组件包含的子组件
                {path: '/app/login', redirect: to => '/login'},
                {path: '/app/home', name: 'apphome', component: AppHome},
                {path: '/app/cars', name: 'cars', component: Cars},
                {path: '/app/userList', name: 'userList', component: userList},
                {path: '/app/userinfo', name: 'userinfo', component: userInfo},
                {path: '/app/carInfo', name: 'carInfo', component: carInfo},
                {path: '/app/employee', name: 'employee', component: Employee}
            ]
        }, {
            path: '/app/home',
            name: 'apphome',
            redirect: to => '/app/cars'
        }
    ]
})
//全局路由守护，必须登录后，才能访问vue中的页面组件
router.beforeEach(async (to, from) => {
    let userInfo = sessionStorage.getItem('userInfo');
    // 检查用户是否已登录 ，并且要访问的url不等于/login 避免无限重定向
    if (!userInfo && to.path !== '/login') {
        // 重定向到登录页面
        return { path: '/login' }
    }

})
export default router;