package com.program.controller;

import com.program.anno.Log;
import com.program.pojo.Dept;
import com.program.pojo.Result;
import com.program.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j  // 日志注解
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;    // 因为 controller 层要调用 service 层，所以要注入 dept 对象, controller 层用于请求和响应前端

    @RequestMapping(value = "/sel_depts", method = RequestMethod.GET)       // 用 GET 请求方式,或者用注解 @GetMapping("/depts")
    public Result list() {
        log.info("查询全部的部门数据");
        // 调用 service 查询部门数据
        List<Dept> deptList = deptService.list();
        return deptList != null ? Result.success(deptList) : Result.error("没有查询到数据");
    }

    @GetMapping("/sel_depts/{id}")   // 根据 id 查询部门信息
    public Result select(@PathVariable Integer id) {
        log.info("根据id查询部门信息");
        Dept dept = deptService.selectById(id);
        return dept != null ? Result.success(dept) : Result.error("没有此id的部门信息");
    }

    @Log
    @DeleteMapping("/del_depts/{id}")
    public Result delete(@PathVariable Integer id) {    // 绑定路径参数
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping( "/ins_depts")     // post 请求方式
    public Result insert(@RequestBody Dept dept) {    // @RequestBody 注解用于前端发送的json格式的数据封装到实体类中
        log.info("新增部门");
        int insert = deptService.insert(dept);
        return insert != 0 ? Result.success() : Result.error("已有该部门，新增失败");
    }

    @Log
    @PutMapping("/up_depts")
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门");
        int update = deptService.update(dept);
        return update != 0 ? Result.success() : Result.error("id错误，修改失败");
    }

}
