<template>
    <div>
<!--        <element-button></element-button>         -->
<!--        <element-table></element-table>           -->
<!--        <element-pagination></element-pagination> -->
<!--        <element-dialog></element-dialog>         -->
<!--        <element-form></element-form>             -->
<!--        <emp-view></emp-view>                     -->
        <router-view></router-view>
    </div>
</template>

<script>

// import ElementButton from "@/views/element/ElementButton.vue";
// import ElementTable from "@/views/element/ElementTable.vue";
// import ElementPagination from "@/views/element/ElementPagination.vue";
// import ElementDialog from "@/views/element/ElementDialog.vue";
// import ElementForm from "@/views/element/ElementForm.vue";
// import EmpView from "@/views/tlias/EmpView.vue";


export default {
    components: {},
    // components: {ElementForm, ElementDialog, ElementTable, ElementButton, ElementPagination, EmpView}
}
const debounce = (fn, delay) => {
    let timer = null;
    return function () {
        let context = this;
        let args = arguments;
        clearTimeout(timer);
        timer = setTimeout(function () {
            fn.apply(context, args);
        }, delay);
    }
}

const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver {
    constructor(callback) {
        callback = debounce(callback, 16);
        super(callback);
    }
}
</script>

<style>

</style>
