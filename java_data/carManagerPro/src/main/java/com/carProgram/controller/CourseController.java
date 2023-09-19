package com.carProgram.controller;

import com.carProgram.pojo.CourseResources;
import com.carProgram.pojo.Result;
import com.carProgram.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public Result select() {
        List<CourseResources> courseResourcesList = courseService.select();
        return Result.success(courseResourcesList);
    }

    @GetMapping("/course/{id}")
    public Result selectById(@PathVariable Integer id) {
        CourseResources courseResources = courseService.selectById(id);
        return Result.success(courseResources);
    }

    @GetMapping("/course/sel/{title}")
    public Result selectByTitle(@PathVariable String title) {
        CourseResources courseResources = courseService.selectByTitle(title);
        return Result.success(courseResources);
    }

    @DeleteMapping("/course/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int num = courseService.deleteById(id);
        return num == 1 ? Result.success() : Result.error("id不存在");
    }

    @DeleteMapping("/course")
    public Result delete() {
        courseService.delete();
        return Result.success();
    }

    @PostMapping("/course")
    public Result insert(@RequestBody CourseResources courseResources) {
        courseService.insert(courseResources);
        return Result.success();
    }

    @PutMapping("/course")
    public Result update(@RequestBody CourseResources courseResources) {
        courseService.update(courseResources);
        return Result.success();
    }
}
