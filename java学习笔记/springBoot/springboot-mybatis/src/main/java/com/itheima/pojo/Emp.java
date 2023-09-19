package com.itheima.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private short gender;
    private String image;
    private short job;
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDate createTime;
    private LocalDate updateTime;
}
