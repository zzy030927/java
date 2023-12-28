<template>
    <!--登录框div的样式-->
    <div class="login">
        <el-card class="loginCard" shadow="hover">
            <el-form :model="login_data" :rules="login_rule" ref="login_form">
                <h2 style="text-align: center">车辆管理系统</h2>
                <el-form-item prop="userLoginId">
                    <el-input type="text" v-model="login_data.loginId" auto-complete="off" placeholder="登录账号">
                    </el-input>
                </el-form-item>
                <el-form-item prop="currentPassword">
                    <el-input type="password" v-model="login_data.currentPassword" auto-complete="off" placeholder="登录密码">
                    </el-input>
                </el-form-item>
                <el-form-item></el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="login(login_form)" style="width: 80% ;margin-left: auto;margin-right: auto;">
                        登 录
                    </el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>
<script setup>
//注意：vue3.x组合式api，需要在<script>里面使用setup
import { ref, reactive } from "vue";
import { ElMessage } from 'element-plus';
//导入axios实例(从封装的http.js中导入)
import http from "../../util/http.js";
//引入路由实例(从封装的myRouter.js中导入)
import router from "../../router/myRouter.js";
//把表单定义为一个响应数据对象
const login_form = ref();
const login_data = reactive({
    userId: '',
    loginId: '',
    currentPassword: '',
    userName: ''
})
const login_rule = ref({
    loginId: [
        { required: true, message: '请输入登录账号', trigger: 'blur' },
    ],
    currentPassword: [
        { required: true, message: '请输入登录密码', trigger: 'blur' },
    ]
})
//登录验证函数
const login = async (form) => {
    let valid = await form.validate();
    if (valid) {
        //TODO: 到后台验证用户
        //模拟登录
        let res = await http.get("/user");
        let loginFlag = false;
        let userInfo = {}
        if (res.status === 200 || res.status === 201) {
            res.data.forEach(user => {
                if (user.loginId === login_data.loginId && user.currentPassword ===
                    login_data.currentPassword) {
                    loginFlag = true;
                    userInfo = {
                        id: user.id,
                        loginId: user.loginId,
                        userName: user.userName,
                        userType: user.userType,
                    };
                }
            })
        }
        if (loginFlag) {
            //验证成功
            //创建一个本地会话，存放用户信息
            sessionStorage.setItem("userInfo", JSON.stringify(userInfo));
            //路由跳转: 可以根据角色跳转到不同的入口
            if (userInfo.userType === '0') {
                router.push('/app/index')
            } else if (userInfo.userType === '1') {
                router.push('/app/carList')
            }
        } else {
            //验证失败
            ElMessage.error({
                message: '用户名/密码错误，请重新登录！'
            })
            //路由跳转:跳转到重新登录页面
            router.push('/login')
        }
    } else {
        ElMessage.error({
            message: '用户名和密码不能为空！'
        })
        return false;
    }
}
</script>
<style scoped>
.login {
    background-size: cover;
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0;
    background-image: url("../../assets/bj1.jpg");
}

.loginCard {
    position: relative;
    top: 200px;
    left: 320px;
    width: 500px;
    margin: 0 auto;
    padding: 0 20px;
    opacity: 0.95;

}
</style>