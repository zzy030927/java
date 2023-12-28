<template>
    <el-card>
        <template #header>
            <div>
                <span>车辆管理</span>&nbsp;&nbsp;&nbsp;&nbsp;
                <el-button class="button" size="small" @click="onAdd()" type="primary">
                    添加车辆
                </el-button>
            </div>
        </template>
        <el-table :data="carList" :stripe="true" style="width:100%;">
            <el-table-column fixed type="index" label="" align="center">
            </el-table-column>
            <el-table-column prop="carName" align="center" label="车辆名称">
                <template #default="scope">
                    <div @click="navigateToCarInfo(scope.row.id)">
                        {{ scope.row.carName }}
                    </div>
                </template>
            </el-table-column>
            <el-table-column prop="carImage" align="center" label="车辆照片">
                <template #default="scope">
                    <img @click="navigateToCarInfo(scope.row.id)" :src="scope.row.carImage" alt="" style="width: 150px;height: 150px">
                </template>
            </el-table-column>
            <el-table-column prop="addCarDate" align="center" label="添加时间">
                <template #default="scope">
                    <span @click="navigateToCarInfo(scope.row.id)" v-text="formatDate(scope.row.addCarDate)"></span>
                </template>
            </el-table-column>
            <el-table-column prop="numbers" label="车辆状态" align="center">
                <template #default="scope">
                    <span @click="navigateToCarInfo(scope.row.id)" v-if="scope.row.numbers == 0">
                        <el-icon :size="30" color="#008000FF">
                            <el-tag type="warning">已售空</el-tag>
                        </el-icon>
                    </span>
                    <span @click="navigateToCarInfo(scope.row.id)" v-if="scope.row.numbers > 0">
                        <el-icon :size="30" color="#008000FF">
                            <el-tag type="success">有剩余</el-tag>
                        </el-icon>
                    </span>
                </template>
            </el-table-column>
            <el-table-column prop="" label="操作" align="center">
                <template #default="scope">
                    <span>
                        <el-button size="small" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
                    </span>
                    <el-button size="small" plain type="danger" @click="dialogVisible = true; selectRow = scope.$index">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog
                v-model="dialogVisible" :close-on-click-modal='false'
                :close-on-press-escape='false' :modal-append-to-body='false'
                width="30%"
                title="是否要删除该车辆"
                :before-close="handleClose">
            <span slot="footer" class="dialog-footer">
                <p></p><p></p>
                <el-button @click="dialogVisible = false; selectRow = -1">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = false; onDelete(selectRow)">确 定</el-button>
            </span>
        </el-dialog>
        <!--对话框-->
        <el-dialog width="40%" v-model="dialog.show" :title="dialog.title" :close-on-click-modal='false'
                   :close-on-press-escape='false' :modal-append-to-body='false'>
            <el-form :model="userData" :rules="rule" ref="myform">
                <el-form-item label="车辆名称" required prop="carName">
                    <el-col :span="15">
                        <el-input type="text" v-model="userData.carName">
                        </el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="车辆图片" required prop="carImage">
                    <el-col :span="15">
                        <el-input type="text" v-model="userData.carImage">
                        </el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="任务日期" required prop="addCarDate">
                    <el-col :span="15">
                        <el-date-picker v-model="userData.addCarDate" type="date" placeholder="选择日期">
                        </el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="车辆剩余数量" required prop="numbers">
                    <el-col :span="15">
                        <el-input type="text" v-model="userData.numbers">
                        </el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="车辆简介" required prop="carInfo">
                    <el-col>
                        <textarea  style="width: 300px; height: 200px; resize: none" v-model="userData.carInfo"></textarea>
                    </el-col>
                </el-form-item>
            </el-form>
            <div>
                <el-button type="primary" @click='onSave("myform")'>保 存</el-button>
                <el-button @click="dialog.show = false;">取 消</el-button>
            </div>
        </el-dialog>
    </el-card>
</template>
<script>
//注意：选项式api，不需要在<script>里面使用setup,兼容vue2.x写法
//导入axios实例(从封装的http.js中导入)
import http from "../../util/http.js";
import {ElMessage} from "element-plus";
import {SuccessFilled, Upload, VideoPlay} from "@element-plus/icons-vue";
import router from "../../router/myRouter.js";

export default {
    name: "carList",
    components: {SuccessFilled, VideoPlay, Upload},
    // 定义响应式数据
    data: function () {
        return {
            carList: [],
            userData: {
                userId: "",
                id: "",
                carName: "",
                carImage: "",
                addCarDate: "",
                numbers: 0,
                carInfo: ""
            },
            rule: {
                carName: [
                    {required: true, message: '车辆名称', trigger: 'blur'},
                ],
                addCarDate: [
                    {required: true, message: '车辆日期不能为空', trigger: 'blur'},
                ],
            },
            dialogVisible: false,
            dialog: {
                title: '',
                show: false,
                option: ''
            },
            selectedIndex: -1,
            userInfo: {},
            itemCurrentStatus: '', //查询任务当前状态,''默认为所有任务
            selectRow: -1
        }
    },
    //生命周期函数
    mounted() {
        this.initTable();
    },
    //定义各种函数
    methods: {
        navigateToCarInfo(id) {
            sessionStorage.setItem("carId", id);
            router.push('/app/carInfo/');
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => {});
        },
        //初始化表格
        initTable() {
            this.userInfo = JSON.parse(sessionStorage.getItem('userInfo'));
            http.get("/cars").then(res => {
                //更新表格
                this.carList = res.data;
            })
        },
        //打开添加任务对话框
        onAdd: function () {
            //清空表单旧数据
            this.userData = {
                userId: "",
                id: "",
                carName: "",
                carImage: "",
                addCarDate: "",
                numbers: 0,
                carInfo: ''
            }
            //打开对话框
            this.dialog = {
                title: '添加车辆',
                show: true,
                option: 'add'
            }
        },
        //打开修改任务对话框
        onEdit: function (index) {
            //回填表单
            let item = this.carList[index];
            this.userData = {
                userId: item.userId,
                id: item.id,
                carName: item.carName,
                carImage: item.carImage,
                addCarDate: item.addCarDate,
                numbers: item.numbers,
                carInfo: item.carInfo
            }
            //临时保存选中的索引
            this.selectedIndex = index
            //打开对话框
            this.dialog = {
                title: '修改车辆信息',
                show: true,
                option: 'edit'
            }
        },
        //保存
        onSave(formName) {
            const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
            if (this.dialog.option === 'add') {
                //添加保存
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.userData.userId = this.userInfo.userId;
                        http.post("/catList", this.userData).then(res => {
                            //console.log(res.data)
                            ElMessage({
                                message: '添加成功！',
                                type: 'success'
                            })
                            //更新表格
                            //this.carList.push(res.data)
                            this.initTable();
                            //清空表单旧数据
                            this.userData = {
                                userId: "",
                                id: "",
                                carName: "",
                                carImage: "",
                                addCarDate: "",
                                numbers: 0,
                                carInfo: ''
                            }
                            //关闭对话框
                            this.dialog = {
                                title: '',
                                show: false,
                                option: ''
                            }
                        })
                    }
                })
            } else if (this.dialog.option === 'edit') {
                //修改保存
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //json-server更新数据需要带一个路径变量id，才能修改
                        http.put("/cars/" + this.userData.id, this.userData).then(res => {
                            ElMessage({
                                message: '修改成功！',
                                type: 'success'
                            })
                            //更新页面
                            this.initTable();
                            //清空表单旧数据
                            this.userData = {
                                userId: "",
                                id: "",
                                carName: "",
                                carImage: "",
                                addCarDate: "",
                                numbers: 0,
                                carInfo: ''
                            }
                            //关闭对话框
                            this.dialog = {
                                title: '',
                                show: false,
                                option: ''
                            }
                        })
                    }
                })
            }
        },
        //完成任务
        updateState: function (index) {
            let item = this.carList[index]
            //状态改为1
            if (item.numbers === 1)
                item.numbers = 0
            else
                item.numbers = 1
            //更新服务器数据
            http.put("/cars/" + this.carList[index].id, item).then(res => {
                ElMessage({
                    message: '任务完成！',
                    type: 'success'
                })
                //更新页面
                //this.carList.splice(index, 1, res.data)
                this.initTable();
            })
        },
        //删除任务
        onDelete: function (index) {
            http.delete("/cars/" + this.carList[index].id).then(res => {
                if (res.status === '200') {
                    ElMessage('删除成功！')
                    this.carList.splice(index, 1)
                    //清空表单旧数据
                    this.userData = {
                        userId: "",
                        id: "",
                        carName: "",
                        carImage: "",
                        addCarDate: "",
                        numbers: 0,
                        carInfo: ''
                    }
                }
                this.initTable();
                this.userData = {
                    userId: "",
                    id: "",
                    carName: "",
                    carImage: "",
                    addCarDate: "",
                    numbers: 0,
                    carInfo: ''
                }
            })
        },
        //时间格式化成中国时间
        formatDate: function (addCarDate) {
            let date = new Date(addCarDate);
            let seperator = "-";
            let year = date.getFullYear();
            let month = date.getMonth() + 1;
            let strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            return year + seperator + month + seperator + strDate
        },
    }
}
</script>
<style>
</style>
