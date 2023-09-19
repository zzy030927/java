package com.program.service.impl;

import com.program.mapper.DeptLogMapper;
import com.program.mapper.DeptMapper;
import com.program.mapper.EmpMapper;
import com.program.pojo.Dept;
import com.program.pojo.DeptLog;
import com.program.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    // 因为 service 层要调用 mapper 层，所以要注入 mapper 层的对象，service层用于 逻辑处理
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }

    @Override
    public Dept selectById(Integer id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }

    @Transactional(rollbackFor = Exception.class)   // 设置出现什么异常要回滚，默认为RuntimeException
                                                    // 事务开启注解，方法执行前开启事务，成功执行后提交事务，出现异常回滚事务
                                                    // 声明位置：业务层的方法、类、接口上
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id);              // 根据id删除部门
            empMapper.deleteByDept(id);             // 根据部门id删除其部门下的员工，因为删除部门后，员工所在的部门就找不到了
                                                    // 所以要开启事务，等方法执行后一起提交事务
        } finally {
            DeptLog deptLog = new DeptLog();        // 每次解散部门，不管出不出现异常都要记录日志
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是"+id+"号部门");
            deptLogMapper.insert(deptLog);
        }

    }

    @Override
    public int insert(Dept dept) {
        List<Dept> deptList = this.list();
        for (Dept currDept : deptList) {
            if (dept.getName().equals(currDept.getName()))
                return 0;
        }
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        int num = deptMapper.insert(dept);
        return num;
    }

    @Override
    public int update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        int num = deptMapper.update(dept);
        return num;
    }
}
