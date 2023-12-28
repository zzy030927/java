<template>
    <el-descriptions direction="vertical" :column="4" border>
        <el-descriptions-item label="车辆" width="300px">{{car.carName}}</el-descriptions-item>
        <el-descriptions-item label="图片" width="400px"><el-image style="width: 150px; height: 150px" :src="car.carImage"></el-image></el-descriptions-item>
        <el-descriptions-item label="添加时间" :span="2">{{car.carAddTime}}</el-descriptions-item>
        <el-descriptions-item label="车辆状态">
            <el-tag type="info" v-if="car.numbers == 0" size="large">已售空</el-tag>
            <el-tag v-else size="large">未售空</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="车辆详细信息">{{car.carInfo}}</el-descriptions-item>
    </el-descriptions>
</template>

<script>
import http from "../../util/http.js";

export default {
    name: "CarInfo",
    data: function () {
        return {
            car: {
                carId: '',
                carName: '',
                carImage: '',
                carAddTime: '',
                carStatus: '',
                carInfo: '',
                numbers: -1
            }
        }
    },
    mounted() {
      this.init();
    },
    methods: {
        init() {
            console.log(this.carId)
            this.carId = JSON.parse(sessionStorage.getItem("carId"))
            http.get("/cars/" + this.carId).then(res => {
                if (res.status === 200) {
                    this.car.carName = res.data.carName;
                    this.car.carImage = res.data.carImage;
                    this.car.carAddTime = this.formatDate(res.data.addCarDate);
                    this.car.carInfo = res.data.carInfo;
                    this.car.numbers = res.data.numbers;
                }
            })
        },
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
        }
    }
}
</script>

<style scoped>

</style>