package com.program.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.program.mapper.EmpMapper;
import com.program.pojo.Emp;
import com.program.pojo.Login;
import com.program.pojo.PageBean;
import com.program.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean page(Integer pageStart, Integer pageSize) {
        List<Emp> limitList = empMapper.page((pageStart - 1) * pageSize, pageSize);
        Long count = empMapper.count();
        return new PageBean(count, limitList);
    }

    @Override
    public PageBean pageHelper(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage((page - 1) * pageSize, pageSize);
        // 执行查询
        List<Emp> empList = empMapper.list();
        // 强转为 Page类型的时候，PageHelper插件会对你查询的记录自动进行分页查询和查询总记录数的操作，并封装到Page类中
        Page<Emp> p = (Page<Emp>) empList;
        // 封装PageBean类
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public PageBean pageHelperIf(String name, Short gender, LocalDate createTime, LocalDate updateTime, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.chooseEmp(name, gender, createTime, updateTime);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Integer[] ids) {
        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp select(Integer id) {
        Emp emp = empMapper.select(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Login login(Login log) {
        Login logRes = empMapper.login(log);
        return logRes;
    }


}
