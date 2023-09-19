package com.carProgram.service;

import com.carProgram.pojo.CourseResources;

import java.util.List;

public interface CourseService {
    List<CourseResources> select();
    CourseResources selectById(Integer id);

    CourseResources selectByTitle(String title);

    int deleteById(Integer id);

    void insert(CourseResources courseResources);

    void update(CourseResources courseResources);

    void delete();
}
