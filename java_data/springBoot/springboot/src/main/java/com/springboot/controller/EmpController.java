package com.springboot.controller;

import com.springboot.pojo.Emp;
import com.springboot.pojo.Result;
import com.springboot.service.EmpService;
import com.springboot.service.impl.EmpServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 三层架构， controller层 用于 接受请求，响应数据
@RestController
public class EmpController {
    // 分层解耦，把控制权交给容器管理，即把 EmpService的实现类放入容器中，用到 EmpService对象时，去容器中找看有没有 EmpService实现类的对象。

    // 不适用分层解耦
    //    private EmpService es = new EmpServiceA();

    // 使用分层解耦
    @Autowired      // 依赖注入，从容器中找到 EmpService的实现类
    private EmpService es;
    @RequestMapping("/listEmp")
    public Result list() {
        // 1. 解析 XML 文件，dao 包中的类用于 解析 XML文件以及访问数据
        // 2. 对数据进行逻辑处理，在 service 包中进行
        List<Emp> empList = es.listEmp();
        // 3. 接受请求，响应数据
        return Result.success(empList);

        /*  这种方式写代码不利于维护，要使用 单一职责原则
            // 1. 解析 XML 文件
            List<Emp> empList = new ArrayList<>();
            String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
            empList = XmlParserUtils.parse(file, Emp.class);
            // 2. 对性别进行转换
            for (Emp emp : empList) {
                emp.setGender(emp.getGender().equals("1") ? "男" : "女");
                emp.setJob(emp.getJob().equals("1") ? "讲师" : emp.getJob().equals("2") ? "班主任" : "就业指导" );
            }
            return Result.success(empList);
        */
    }
}
