package com.springboot.dao;

import com.springboot.pojo.Emp;
import java.util.List;

// dao 层用于访问数据，并将数据返回给 service
public interface EmpDao {
    // 获取员工列表数据, 为了增强灵活性，所以要把这个 访问数据的类声明为 接口
    public List<Emp> listEmp();

}
