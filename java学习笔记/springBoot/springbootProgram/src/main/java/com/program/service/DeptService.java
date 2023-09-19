package com.program.service;

import com.program.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    // 查询全部部门数据
    public List<Dept> list();

    public void delete(Integer id);

    public int insert(Dept dept);

    public int update(Dept dept);

    public Dept selectById(Integer id);
}
