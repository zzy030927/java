<template>
    <el-pagination background
                   layout="sizes, prev, pager, next, jumper"
                   @size-change="handleSizeChange"
                   @current-change="handleCurrentChange"
                   v-bind:total="1000"></el-pagination>
</template>

<script>
export default {
    name: "ElementPagination",
    methods : {
        handleSizeChange(val) {
            alert("每页记录数变化为" + val);
        },
        handleCurrentChange(val) {
            alert("页码变化为" + val);
        }
    }
}
</script>

<style scoped>

</style>