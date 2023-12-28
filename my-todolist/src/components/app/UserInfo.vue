<template>
    <div style="font-size: 30px; color: coral">{{user.name}}个人信息</div>
    <p></p>
    <el-descriptions direction="vertical" :column="3" border>
        <el-descriptions-item label="用户账号">{{user.id}}</el-descriptions-item>
        <el-descriptions-item label="用户名">{{user.name}}</el-descriptions-item>
        <el-descriptions-item label="手机号">{{user.mobile}}</el-descriptions-item>
        <el-descriptions-item label="用户类型" :span="1">
            <el-tag size="small">{{user.userType}}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="邮箱" >{{user.email}}</el-descriptions-item>
    </el-descriptions>
</template>

<script>
import http from "../../util/http.js";

export default {
    name: "userInfo",
    data: function () {
        return {
            user: {
                id: '',
                name: '',
                email: '',
                mobile: '',
                userType: ''
            },
            id : -1
        }
    },
    mounted() {
        this.initView();
    },
    methods: {
        initView() {
            let user = JSON.parse(sessionStorage.getItem("userInfo"));
            this.id = user.id;
            http.get("/user").then(res => {
                for (let dataKey in res.data) {
                    if (res.data[dataKey].id === this.id) {
                        this.user.id = res.data[dataKey].loginId;
                        this.user.name = res.data[dataKey].userName;
                        this.user.email = res.data[dataKey].email;
                        this.user.mobile = res.data[dataKey].mobile;
                        this.user.userType = res.data[dataKey].userType;
                        if (this.user.userType === "0") {
                            this.user.userType = '系统管理员'
                        } else {
                            this.user.userType = '用户'
                        }
                    }
                }
            })
        }
    }
}
</script>

<style scoped>

.item {
    height: 30px;
    font-size: 17px;
}

.box-card {
    width: 100%;
}
</style>