package com.program.controller;

import com.program.anno.Log;
import com.program.pojo.Emp;
import com.program.pojo.PageBean;
import com.program.pojo.Result;
import com.program.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

/**
 * 员工管理Controller
 */
@RestController
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    // 参数名与前端传入的参数名一致，值自动接受
    // 注意 GET方式路径参数与携带参数的区别，路径参数emps/1/2，携带参数emps?page=1&pageSize=2
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询");
        PageBean pageBean = empService.page(page, pageSize);
        return Result.success(pageBean);
    }

    // 上面分页查询代码比较繁琐，下面这个方面用到了 PageHelper 插件，代码简洁
    @GetMapping("/emps1")
    public Result pageHelper(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询");
        PageBean pageBean = empService.page(page, pageSize);
        return Result.success(pageBean);
    }

    // 根据条件进行分页查询
    @GetMapping("/emps2")
    public Result pageHelperIf(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               String name, Short gender,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createTime,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updateTime) {
        log.info("分页条件查询,name,gender,createTime,updateTime,page,pageSize");
        PageBean pageBean = empService.pageHelperIf(name, gender, createTime, updateTime, page, pageSize);
        return Result.success(pageBean);
    }

    // 单独删除/批量删除
    @Log
    @DeleteMapping("/emps/{ids}")       // ids 为一个数组
    public Result delete(@PathVariable Integer[] ids) {
        log.info("批量删除");
        empService.delete(ids);
        return Result.success();
    }

    // 添加员工
    @Log
    @PostMapping("/emps")
    public Result insert(@RequestBody Emp emp) {
        log.info("插入员工数据");
        empService.insert(emp);
        return Result.success();
    }

    // 根据Id查询员工信息
    @GetMapping("emps/{id}")
    public Result select(@PathVariable Integer id) {
        log.info("根据Id查询员工信息");
        Emp emp = empService.select(id);
        return Result.success(emp);
    }

    // 根据id修改员工信息
    @Log
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        log.info("根据Id更新员工信息");
        empService.update(emp);
        return Result.success();
    }

}
