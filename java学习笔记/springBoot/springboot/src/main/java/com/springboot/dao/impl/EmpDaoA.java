package com.springboot.dao.impl;

import com.springboot.dao.EmpDao;
import com.springboot.pojo.Emp;
import com.springboot.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        // 1. 解析 XML 文件
        List<Emp> empList = new ArrayList<>();
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
