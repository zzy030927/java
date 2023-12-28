<template>
  <!--普通用户的首页框架-->
    <el-container class="index">
        <el-header class="header">
            <el-row>
                <!--左侧logo区域-->
                <el-col :span="12" class="logo-container">
                    <img src="../../assets/name.png" class="logo" alt="logo"/>
                    <span class="title">车辆管理系统</span>
                </el-col>
                <!--右侧用户信息区域-->
                <el-col :span="12" class="user">
                    <span>{{ userInfo.userName }}</span>&nbsp;&nbsp;
                    <el-link :underline="false" type="primary" @click="logout">
                        <el-icon>
                            <switch-button></switch-button>
                        </el-icon>
                    </el-link>
                </el-col>
            </el-row>
        </el-header>
        <el-container class="container">
            <el-aside class="lefter">
                <el-scrollbar>
                    <el-menu
                            class="el-menu-vertical"
                            background-color="#324057"
                            text-color="#fff"
                            active-text-color="#409eff">
                        <el-sub-menu index="1">
                            <template #title>
                                <el-icon>
                                    <Tickets/>
                                </el-icon>
                                车辆管理
                            </template>
                            <router-link to="/app/cars">
                                <el-menu-item index="1-1">
                                    <el-icon>
                                        <List/>
                                    </el-icon>
                                    车辆列表
                                </el-menu-item>
                            </router-link>
                            <router-link to="/app/carInfo">
                                <el-menu-item index="1-2">
                                    <el-icon>
                                        <info-filled/>
                                    </el-icon>
                                    车辆信息
                                </el-menu-item>
                            </router-link>
                        </el-sub-menu>
                        <el-sub-menu index="2">
                            <template #title>
                                <el-icon>
                                    <House/>
                                </el-icon>
                                用户管理
                            </template>
                            <router-link to="/app/userlist">
                                <el-menu-item index="2-1">
                                    <el-icon>
                                        <User/>
                                    </el-icon>
                                    用户管理
                                </el-menu-item>
                            </router-link>
                            <router-link to="/app/employee">
                                <el-menu-item index="2-2">
                                    <el-icon>
                                        <Goods/>
                                    </el-icon>
                                    顾客管理
                                </el-menu-item>
                            </router-link>
                        </el-sub-menu>
                        <router-link to="/app/userinfo">
                            <el-menu-item index="3">
                                <el-icon>
                                    <User/>
                                </el-icon>
                                个人中心
                            </el-menu-item>
                        </router-link>
                        <el-menu-item index="4" @click="logout">
                            <el-icon>
                                <SwitchButton/>
                            </el-icon>
                            退出系统
                        </el-menu-item>
                    </el-menu>
                </el-scrollbar>
            </el-aside>
            <el-main class="content">
                <el-scrollbar>
                    <!--通过router-view加载其他组件-->
                    <router-view></router-view>
                </el-scrollbar>
            </el-main>
        </el-container>
    </el-container>
</template>
<script>
//注意：选项式api，不需要在<script>里面使用setup,兼容vue2.x写法
//引入路由实例(从封装的myRouter.js中导入)
import router from "../../router/myRouter.js";
import {InfoFilled, SwitchButton} from "@element-plus/icons-vue";

export default {
    name: "AppIndex",
    components: {InfoFilled, SwitchButton},
    //定义响应数据
    data: function () {
        return {
            userInfo: {
                userId: '',
                loginId: '',
                userName: ''
            }
        }
    },
    //使用生命周期函数
    mounted() {
        //获得登录用户信息
        //通过this引用data中定义的数据
        if (JSON.parse(sessionStorage.getItem('userInfo')) != null) {
            this.userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
        }
        //路由到默认首页页面
        router.push("/app/home")
    },
    methods: {
        logout: function () {
            sessionStorage.removeItem('userInfo')
            router.replace('/')
        }
    }
}
</script>

<style scoped>
/*定义index页面的布局及样式*/
.index {
    width: 100%;
    height: 100%;
}

/*头部样式*/
.header {
    box-sizing: border-box;
    width: 100%;
    height: 72px;
    min-width: 600px;
    padding: 5px;
    background: #324057;
    color: #fff;
    border-bottom: 1px solid #324057;
}

.logo-container {
    line-height: 60px;
    min-width: 400px;
}

.logo {
    height: 50px;
    width: 50px;
    margin-right: 5px;
    vertical-align: middle;
    display: inline-block;
}

.title {
    vertical-align: middle;
    font-size: 22px;
    letter-spacing: 3px;
}

.user {
    line-height: 60px;
    text-align: right;
    float: right;
    padding-right: 20px;
}

.container {
    box-sizing: border-box;
    width: 100%;
    height: calc(100% - 72px);
}

/*左侧菜单样式*/
.lefter {
    box-sizing: border-box;
    width: 220px;
    min-height: 100%;
    margin: 0;
    padding: 0;
    background-color: #324057;
}

.el-menu {
    border: none;
}

.el-menu-vertical:not(.el-menu--collapse) {
    width: 220px;
    min-height: 400px;
    margin: 0;
    padding: 0;
}

.el-menu-vertical {
    margin: 0;
    width: 220px;
    margin: 0;
    padding: 0;
}

.el-submenu .el-menu-item {
    min-width: 220px;
}

.el-menu-item {
    width: 220px;
}

a {
    text-decoration: none;
}

.el-menu-item.is-active {
    background-color: #296a4d;
}

.content {
    padding: 20px;
    box-sizing: border-box;
    width: 100%;
    height: 100%;
}
</style>