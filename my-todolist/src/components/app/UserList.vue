<template>
    <el-card>
        <template #header>
            <div>
                <span>用户列表</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <el-button class="button" size="small" @click="onAdd()" type="primary">
                    注册用户
                </el-button>
            </div>
        </template>
        <div class="table-container">
            <el-table :data="state.list" stripe style="width: 100%">
                <el-table-column type="index" prop="" label="">
                </el-table-column>
                <el-table-column prop="loginId" align="center" label="账号">
                </el-table-column>
                <el-table-column prop="userName" align="center" label="姓名">
                </el-table-column>
                <el-table-column prop="userType" align="center" label="用户类型">
                    <template #default="scope">
                        <span v-if="scope.row.userType === '0'">系统管理员</span>
                        <span v-if="scope.row.userType === '1'">普通账号</span>
                    </template>
                </el-table-column>
                <el-table-column prop="email" align="center" label="邮箱">
                </el-table-column>
                <el-table-column prop="mobile" align="center" label="电话号码">
                </el-table-column>
                <el-table-column prop="" label="操作" align="center">
                    <template #default="scope">
                        <el-button size="small" plain type="primary" @click="onEdit(scope.$index)">&nbsp;修改</el-button>
                        <el-popconfirm title="确定删除该数据吗？" @confirm="onDelete(scope.$index)">
                            <template #reference>
                                <el-button size="small" plain type="danger">&nbsp;删除</el-button>
                            </template>
                        </el-popconfirm>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <!--注册/修改用户对话框-->
        <el-dialog width="50%" v-model="state.dialog.show" :title="state.dialog.title" :close-on-click-modal='false'
            :close-on-press-escape='false' :modal-append-to-body='false'>
            <!--使用el-form组件进行数据添加和修改-->
            <el-form ref="userForm" :model="state.userList" label-width="150px" style="margin:10px;width:auto;">
                <el-form-item label="登录账号" required>
                    <el-col :span="15">
                        <el-form-item prop='loginId'>
                            <el-input type="string" v-model="state.userList.loginId"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item label="登录密码" required>
                    <el-col :span="15">
                        <el-form-item prop='currentPassword'>
                            <el-input type="password" v-model="state.userList.currentPassword"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item prop='currentPassword2' label="重复密码">
                    <el-col :span="15">
                        <el-input type="password" v-model="state.userList.currentPassword2"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item prop='userType' label="账号类型:">
                    <!--使用label表示值-->
                    <el-radio-group v-model="state.userList.userType">
                        <el-radio-button label="0">系统管理员</el-radio-button>
                        <el-radio-button label="1">普通账号</el-radio-button>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="姓名" required>
                    <el-col :span="15">
                        <el-form-item prop='userName'>
                            <el-input type="string" v-model="state.userList.userName"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item prop='mobile' label="手机号码:">
                    <el-col :span="15">
                        <el-input type="string" v-model="state.userList.mobile"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item prop='email' label="电子邮箱:">
                    <el-col :span="15">
                        <el-input type="string" v-model="state.userList.email"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item class="text_right">
                    <el-button type="primary" @click='onSave(userForm)'>保 存</el-button>
                    <el-button @click="state.dialog.show = false">取 消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-card>
</template>
<script setup>
//注意：vue3.x组合式api，需要在<script>里面使用setup
import { ref, reactive, onMounted } from "vue";
import { ElMessage } from 'element-plus';
//导入axios实例(从封装的http.js中导入)
import http from "../../util/http.js";
//使用一个reactive方法定义响应式对象
const state = reactive({
    list: [],
    //与表单绑定
    userList: {
        id: '',
        loginId: '',
        userName: '',
        currentPassword: '',
        currentPassword2: '',
        email: '',
        mobile: '',
        userType: '1',
        currentStatus: '0'
    },
    //控制对话框
    dialog: {
        title: '',
        show: false,
        option: ''
    },
    //临时保存选中的行索引
    selectedIndex: -1,
})
//生命周期钩子
onMounted(() => {
    http.get("/user").then(res => {
        if (res.status === 200 || res.status === 201) {
            //更新表格
            state.list = res.data;
        }
    }).catch(err => {
        console.log(err)
        ElMessage.error('获取数据失败');
    })
})
//响应注册按钮,打开注册对话框
const onAdd = () => {
    //清空表单
    state.userList = {
        id: '',
        userName: '',
        loginId: '',
        currentPassword: '',
        currentPassword2: '',
        email: '',
        mobile: '',
        userType: '1',
        currentStatus: '0'
    }
    //弹出注册对话框
    state.dialog = {
        title: '用户注册',
        show: true,
        option: 'add'
    }
}
//响应修改按钮,打开修改对话框
const onEdit = (index) => {
    //获得要修改用户的信息
    let user = state.list[index];
    //临时保存选中的索引
    state.selectedIndex = index;
    //回填数据
    state.userList = {
        id: user.id,
        loginId: user.loginId,
        userName: user.userName,
        currentPassword: user.currentPassword,
        currentPassword2: user.currentPassword,
        email: user.email,
        mobile: user.mobile,
        userType: user.userType,
        currentStatus: user.currentStatus
    }
        //弹出注册对话框
        state.dialog = {
            title: '修改用户信息',
            show: true,
            option: 'update'
        }
}
//响应删除按钮
const onDelete = async (index) => {
    //删除被选中的数据
    let id = state.list[index].id;
    let res = await http.delete("/user/" + id)
    if (res.status === 200 || res.status === 201) {
        ElMessage("删除成功");
        // 删除起始下标为1，长度为1的一个值
        state.list.splice(index, 1);
    }
}
//响应注册对话框保存按钮
const userForm = ref();
const onSave = async (form) => {
    if (state.dialog.option === 'add') {
        //响应注册的保存动作
        let valid = await form.validate();
        if (valid) {
            let res = await http.post("/user", state.userList)
            if (res.status === 200 || res.status === 201) {// 操作成功
                ElMessage({
                    message: "保存成功！",
                    type: "success"
                });
                //更新表格
                state.list.push(res.data);
                //清空表单
                state.userList = {
                    id: '',
                    userName: '',
                    loginId: '',
                    currentPassword: '',
                    currentPassword2: '',
                    email: '',
                    mobile: '',
                    userType: '1',
                    currentStatus: '0'
                }
                //关闭对话框
                state.dialog = {
                    title: '',
                    show: false,
                    option: ''
                }
            } else {
                ElMessage({
                    message: "保存失败！",
                    type: "error"
                });
            }
        }
    } else if (state.dialog.option === 'update') {
        //响应修改的保存动作
        await form.validate(valid => {
            if (valid) {
                http.put("/user/" + state.userList.id, state.userList).then(res => {
                    //操作成功
                    ElMessage({
                        message: "保存成功！",
                        type: "success"
                    });
                    //更新表格
                    state.list.splice(state.selectedIndex, 1, res.data)
                    //清空表单
                    state.userList = {
                        id: '',
                        loginId: '',
                        userName: '',
                        currentPassword: '',
                        currentPassword2: '',
                        email: '',
                        mobile: '',
                        userType: '1',
                        currentStatus: '0'
                    }
                    //重置selectedIndex
                    state.selectedIndex = -1;
                    //关闭对话框
                    state.dialog = {
                        title: '',
                        show: false,
                        option: ''
                    }
                })
            }
        })
    }
}
</script>
<style scoped>
.table-container {
    text-align: right;
}
</style>