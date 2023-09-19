package com.carProgram.mapper;

import com.carProgram.pojo.LessonPlanResources;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LessonMapper {
    @Select("SELECT * FROM lesson_plan_resources")
    List<LessonPlanResources> select();

    @Select("SELECT * FROM lesson_plan_resources WHERE id = #{id}")
    LessonPlanResources selectById(Integer id);

    @Select("SELECT * FROM lesson_plan_resources WHERE title = #{title}")
    LessonPlanResources selectByTitle(String title);

    @Delete("DELETE FROM lesson_plan_resources WHERE id = #{id}")
    int deleteById(Integer id);

    @Delete("DELETE FROM lesson_plan_resources")
    void delete();

    void insert(LessonPlanResources lessonPlanResources);

    void update(LessonPlanResources lessonPlanResources);
}
