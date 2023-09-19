package com.carProgram.controller;

import com.carProgram.pojo.LessonPlanResources;
import com.carProgram.pojo.Result;
import com.carProgram.service.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/lesson")
    public Result select() {
        List<LessonPlanResources> courseResourcesList = lessonService.select();
        return Result.success(courseResourcesList);
    }

    @GetMapping("/lesson/{id}")
    public Result selectById(@PathVariable Integer id) {
        LessonPlanResources lessonPlanResources = lessonService.selectById(id);
        return Result.success(lessonPlanResources);
    }

    @GetMapping("/lesson/sel/{title}")
    public Result selectByTitle(@PathVariable String title) {
        LessonPlanResources lessonPlanResources = lessonService.selectByTitle(title);
        return Result.success(lessonPlanResources);
    }

    @DeleteMapping("/lesson/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int num = lessonService.deleteById(id);
        return num == 1 ? Result.success() : Result.error("id不存在");
    }

    @DeleteMapping("/lesson")
    public Result delete() {
        lessonService.delete();
        return Result.success();
    }

    @PostMapping("/lesson")
    public Result insert(@RequestBody LessonPlanResources lessonPlanResources) {
        lessonService.insert(lessonPlanResources);
        return Result.success();
    }

    @PutMapping("/lesson")
    public Result update(@RequestBody LessonPlanResources lessonPlanResources) {
        lessonService.update(lessonPlanResources);
        return Result.success();
    }
}
