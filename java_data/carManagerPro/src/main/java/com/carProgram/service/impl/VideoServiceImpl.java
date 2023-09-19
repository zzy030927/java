package com.carProgram.service.impl;

import com.carProgram.mapper.VideoMapper;
import com.carProgram.pojo.TrainingVideos;
import com.carProgram.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<TrainingVideos> select() {
        List<TrainingVideos> trainingVideos = videoMapper.select();
        return trainingVideos;
    }

    @Override
    public TrainingVideos selectById(Integer id) {
        TrainingVideos trainingVideos = videoMapper.selectById(id);
        return trainingVideos;
    }

    @Override
    public TrainingVideos selectByTitle(String title) {
        TrainingVideos trainingVideos = videoMapper.selectByTitle(title);
        return trainingVideos;
    }

    @Override
    public int deleteById(Integer id) {
        int num = videoMapper.deleteById();
        return num;
    }

    @Override
    public void delete() {
        videoMapper.delete();
    }

    @Override
    public void insert(TrainingVideos trainingVideos) {
        trainingVideos.setCreatedAt(LocalDateTime.now());
        trainingVideos.setUpdateAt(LocalDateTime.now());
        videoMapper.insert(trainingVideos);
    }

    @Override
    public void update(TrainingVideos trainingVideos) {
        trainingVideos.setUpdateAt(LocalDateTime.now());
        videoMapper.update(trainingVideos);
    }
}
