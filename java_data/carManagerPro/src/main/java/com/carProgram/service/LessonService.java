package com.carProgram.service;

import com.carProgram.pojo.LessonPlanResources;

import java.util.List;

public interface LessonService {
    List<LessonPlanResources> select();

    LessonPlanResources selectById(Integer id);

    LessonPlanResources selectByTitle(String title);

    int deleteById(Integer id);

    void delete();

    void insert(LessonPlanResources lessonPlanResources);

    void update(LessonPlanResources lessonPlanResources);
}
