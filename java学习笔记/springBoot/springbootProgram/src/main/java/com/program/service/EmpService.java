package com.program.service;

import com.program.pojo.Emp;
import com.program.pojo.Login;
import com.program.pojo.PageBean;

import java.time.LocalDate;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize);

    PageBean pageHelper(Integer page, Integer pageSize);

    PageBean pageHelperIf(String name, Short gender, LocalDate createTime, LocalDate updateTime, Integer page, Integer pageSize);

    void delete(Integer[] ids);

    void insert(Emp emp);

    Emp select(Integer id);

    void update(Emp emp);

    Login login(Login login);
}
