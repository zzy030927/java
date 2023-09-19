package com.carProgram.service.impl;

import com.carProgram.mapper.LessonMapper;
import com.carProgram.pojo.LessonPlanResources;
import com.carProgram.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonMapper lessonMapper;

    @Override
    public List<LessonPlanResources> select() {
        List<LessonPlanResources> lessonPlanResourcesList = lessonMapper.select();
        return lessonPlanResourcesList;
    }

    @Override
    public LessonPlanResources selectById(Integer id) {
        LessonPlanResources lessonPlanResources = lessonMapper.selectById(id);
        return lessonPlanResources;
    }

    @Override
    public LessonPlanResources selectByTitle(String title) {
        LessonPlanResources lessonPlanResources = lessonMapper.selectByTitle(title);
        return lessonPlanResources;
    }

    @Override
    public int deleteById(Integer id) {
        int num = lessonMapper.deleteById(id);
        return num;
    }

    @Override
    public void delete() {
        lessonMapper.delete();
    }

    @Override
    public void insert(LessonPlanResources lessonPlanResources) {
        lessonPlanResources.setCreatedAt(LocalDateTime.now());
        lessonPlanResources.setUpdateAt(LocalDateTime.now());
        lessonMapper.insert(lessonPlanResources);
    }

    @Override
    public void update(LessonPlanResources lessonPlanResources) {
        lessonPlanResources.setUpdateAt(LocalDateTime.now());
        lessonMapper.update(lessonPlanResources);
    }
}
