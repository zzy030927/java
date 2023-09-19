package com.carProgram.service.impl;

import com.carProgram.mapper.CourseMapper;
import com.carProgram.pojo.CourseResources;
import com.carProgram.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    // 查询全部课件信息
    @Override
    public List<CourseResources> select() {
        List<CourseResources> courseResourcesList = courseMapper.select();
        return courseResourcesList;
    }
    // 通过Id查询课件资源信息
    @Override
    public CourseResources selectById(Integer id) {
        CourseResources courseResources = courseMapper.selectById(id);
        return courseResources;
    }
    @Override
    public CourseResources selectByTitle(String title) {
        CourseResources courseResources = courseMapper.selectByTitle(title);
        return courseResources;
    }

    // 通过id删除课件资源
    @Override
    public int deleteById(Integer id) {
        int num = courseMapper.deleteById(id);
        return num;
    }

    // 插入课件资源
    @Override
    public void insert(CourseResources courseResources) {
        courseResources.setCreatedAt(LocalDateTime.now());
        courseResources.setUpdateAt(LocalDateTime.now());
        courseMapper.insert(courseResources);
    }

    // 更新课件资源
    @Override
    public void update(CourseResources courseResources) {
        courseResources.setUpdateAt(LocalDateTime.now());
        courseMapper.update(courseResources);
    }

    // 删除全部课件资源
    @Override
    public void delete() {
        courseMapper.delete();
    }
}
