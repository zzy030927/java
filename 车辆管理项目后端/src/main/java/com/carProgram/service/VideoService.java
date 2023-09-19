package com.carProgram.service;

import com.carProgram.pojo.TrainingVideos;

import java.util.List;

public interface VideoService {
    List<TrainingVideos> select();

    TrainingVideos selectById(Integer id);

    TrainingVideos selectByTitle(String title);

    int deleteById(Integer id);

    void delete();

    void insert(TrainingVideos trainingVideos);

    void update(TrainingVideos trainingVideos);
}
