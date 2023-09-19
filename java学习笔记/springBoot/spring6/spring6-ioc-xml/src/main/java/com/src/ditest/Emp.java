package com.src.ditest;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@NoArgsConstructor
@Data
public class Emp {
    // 对象员工属性：员工属于某个部门
    private Dept dept;
    // 员工名称
    private String eName;
    // 员工年龄
    private Integer age;
    // 爱好
    private String[] hobby;

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", eName='" + eName + '\'' +
                ", age=" + age + '}';
    }

    public void work() {
        System.out.println(eName +" "+ age + " work in " + dept.getDName());
        System.out.println("兴趣爱好: " + Arrays.toString(hobby));
        dept.info();
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.work();
    }
}
