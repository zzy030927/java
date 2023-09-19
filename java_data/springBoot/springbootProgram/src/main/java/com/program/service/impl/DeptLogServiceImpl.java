package com.program.service.impl;

import com.program.mapper.DeptLogMapper;
import com.program.pojo.DeptLog;
import com.program.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)      // A方法调用该方法，如果A方法本身也开启一个事务，
                                                                // 那么REQUIRES_NEW为另外开启一个新事务
                                                                // 默认值为加入到A方法的事务中
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
