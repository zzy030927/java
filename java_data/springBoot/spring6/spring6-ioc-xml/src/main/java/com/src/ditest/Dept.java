package com.src.ditest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept {
    private String dName;
    private List<Emp> empList;

    @Override
    public String toString() {
        return "Dept{" +
                "dName='" + dName + '\'' +
                '}';
    }

    public void info() {
        System.out.println("该部门内所有员工: " + Collections.singletonList(empList));
    }
}
