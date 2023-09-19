package com.carProgram.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonPlanResources {
    private Integer id;
    private String title;
    private String description;
    private String filePath;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
