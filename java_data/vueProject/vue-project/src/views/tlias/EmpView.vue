<template>
    <div>
        <el-container style="border: 1px solid #eee">
            <el-header style="font-size: 40px; background-color: gainsboro">tlias 智能学习辅助系统</el-header>
            <el-container>
                <el-aside width="210px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="2">
                            <template slot="title"><i class="el-icon-menu"></i>系统信息管理</template>
                            <el-menu-item index="2-1">
                                <router-link to="/emp">员工管理</router-link>
                            </el-menu-item>
                            <el-menu-item index="2-2">
                                <router-link to="/dept">部门管理</router-link>
                            </el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>

                <el-main>
                    <!--                    表单 -->
                    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
                        <el-form-item label=" 姓名">
                            <el-input v-model="searchForm.name" placeholder="姓名"></el-input>
                        </el-form-item>
                        <el-form-item label=" 性别">
                            <el-select v-model="searchForm.gender" placeholder="性别">
                                <el-option label="男" value="male"></el-option>      <!-- 点击 提交时 服务端获取到的数据为 value-->
                                <el-option label="女" value="female"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label=" 入职时间">
                            <div class="block">
                                <span class="demonstration"></span>
                                <el-date-picker
                                        v-model="searchForm.entrydate"
                                        type="daterange"
                                        range-separator="至"
                                        start-placeholder="开始日期"
                                        end-placeholder="结束日期">
                                </el-date-picker>
                            </div>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">查询</el-button>
                        </el-form-item>
                    </el-form>

                    <!--                    表格-->
                    <el-table :data="tableData1" border header-align="center">
                        <el-table-column prop="name" label="姓名" width="180">
                        </el-table-column>
                        <el-table-column label="图像" width="150">
                            <template slot-scope="scope">
                                <img :src="scope.row.img" width="100px" height="70px">
                            </template>
                        </el-table-column>
                        <el-table-column label="性别" width="60">
                            <template slot-scope="scope">
                                <span style="margin-left: 10px">{{ scope.row.gender == 1 ? "女" : "男" }}</span>
                            </template>
                        </el-table-column>
                        <el-table-column prop="entrydate" label="入职日期" width="180">
                        </el-table-column>
                        <el-table-column prop="updatetime" label="最后操作时间" width="180">
                        </el-table-column>
                        <el-table-column label="操作">
                            <el-button type="primary" size="mini">编辑</el-button>
                            <el-button type="danger" size="mini">删除</el-button>
                        </el-table-column>
                    </el-table>
                    <br>
                    <!-- 分页条-->
                    <el-pagination background
                                   layout="total, prev, pager, next, jumper"
                                   @size-change="handleSizeChange"
                                   @current-change="handleCurrentChange"
                                   page-size="5"
                                   v-bind:total="tableData1.length">
                    </el-pagination>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: "EmpView",
    data() {
        const item = {
            img: "https://gss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/9f2f070828381f30fdf1be0da9014c086f06f0ad.jpg",
            name: '王小虎',
            gender: '男',
            entrydate: "2023-01-01",
            updatetime: "2059-01-01"
        };
        return {
            tableData: [],
            tableData1: Array(20).fill(item),
            searchForm: {
                user: '',
                gender: '',
                entrydate: []
            }
        }
    },
    methods: {
        onSubmit() {
            console.log('submit!');
        },
        handleSizeChange(val) {
            alert("每页记录数变化为" + val);
        },
        handleCurrentChange(val) {
            alert("页码变化为" + val);
        },
        mounted() {
            // 发送异步请求
            axios.get("http://location:8080/emp/list").then((result) => {
                this.tableData = result.data.data;
            });
        }
    }
}
</script>

<style scoped>

</style>