package com.springboot.service.impl;

import com.springboot.dao.EmpDao;
import com.springboot.dao.impl.EmpDaoA;
import com.springboot.pojo.Emp;
import com.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component  // 此注解用于 将 该类 交给容器管理，即交出控制权
public class EmpServiceA implements EmpService {
    @Qualifier("empDaoA")       // 如果容器中有两个 EmpDao的实现类，需要 @Qualifier 注解声明使用的哪个实现类，
                                // 或者把 @Primary这个注解加在你想要的实现类上
                                // 再或者使用 @Resource(name = "empDaoA") 这个注解从容器中取出 EmpDao的具体实现类对象
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        for (Emp emp : empList) {
            emp.setGender(emp.getGender().equals("1") ? "男" : "女");
            emp.setJob(emp.getJob().equals("1") ? "讲师" : emp.getJob().equals("2") ? "班主任" : "就业指导" );
        }
        return empList;
    }
}
