package com.carProgram.controller;


import com.carProgram.pojo.Result;
import com.carProgram.pojo.TrainingVideos;
import com.carProgram.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/video")
    public Result select() {
        List<TrainingVideos> trainingVideos = videoService.select();
        return Result.success(trainingVideos);
    }

    @GetMapping("/video/{id}")
    public Result selectById(@PathVariable Integer id) {
        TrainingVideos trainingVideos = videoService.selectById(id);
        return Result.success(trainingVideos);
    }

    @GetMapping("/video/sel/{title}")
    public Result selectByTitle(@PathVariable String title) {
        TrainingVideos trainingVideos = videoService.selectByTitle(title);
        return Result.success(trainingVideos);
    }

    @DeleteMapping("/video/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int num = videoService.deleteById(id);
        return num == 1 ? Result.success() : Result.error("id不存在");
    }

    @DeleteMapping("/video")
    public Result delete() {
        videoService.delete();
        return Result.success();
    }

    @PostMapping("/video")
    public Result insert(@RequestBody TrainingVideos trainingVideos) {
        videoService.insert(trainingVideos);
        return Result.success();
    }

    @PutMapping("/video")
    public Result update(@RequestBody TrainingVideos trainingVideos) {
        videoService.update(trainingVideos);
        return Result.success();
    }
}
