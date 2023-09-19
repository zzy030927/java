package com.springboot.service;

import com.springboot.pojo.Emp;
import java.util.List;

// service 层用于数据的逻辑处理
public interface EmpService {
    // 对数据进行逻辑处理
    public List<Emp> listEmp();
}
