package com.src.dimap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private List<Lesson> lessonList;
    private Map<String, Teacher> map;
    private String sid;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void run() {
        System.out.println("学生编号: " + sid +
                           "学生姓名: " + name +
                           "选择的课程："+ lessonList.toString());
    }
}
