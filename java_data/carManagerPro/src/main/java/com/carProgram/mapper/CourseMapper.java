package com.carProgram.mapper;

import com.carProgram.pojo.CourseResources;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("SELECT * FROM course_resources")
    List<CourseResources> select();

    @Select("SELECT * FROM course_resources WHERE id = #{id}")
    CourseResources selectById(Integer id);

    @Select("SELECT * FROM course_resources WHERE title = #{title}")
    CourseResources selectByTitle(String title);

    @Delete("DELETE FROM course_resources WHERE id = #{id}")
    int deleteById(Integer id);

    void insert(CourseResources courseResources);

    void update(CourseResources courseResources);

    @Delete("DELETE FROM course_resources")
    void delete();
}
