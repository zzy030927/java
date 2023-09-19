package com.carProgram.mapper;

import com.carProgram.pojo.TrainingVideos;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoMapper {
    @Select("SELECT * FROM training_videos")
    List<TrainingVideos> select();

    @Select("SELECT * FROM training_videos WHERE id = #{id}")
    TrainingVideos selectById(Integer id);

    @Select("SELECT * FROM training_videos WHERE title = #{title}")
    TrainingVideos selectByTitle(String title);

    @Delete("DELETE FROM training_videos WHERE id = #{id}")
    int deleteById();

    @Delete("DELETE FROM training_videos")
    void delete();

    void insert(TrainingVideos trainingVideos);

    void update(TrainingVideos trainingVideos);
}
