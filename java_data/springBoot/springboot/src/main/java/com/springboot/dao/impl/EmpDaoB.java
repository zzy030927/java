package com.springboot.dao.impl;

import com.springboot.dao.EmpDao;
import com.springboot.pojo.Emp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpDaoB implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        return null;
    }
}
