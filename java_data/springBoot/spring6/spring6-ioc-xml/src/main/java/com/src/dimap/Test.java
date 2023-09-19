package com.src.dimap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");
        Student student = context.getBean("student", Student.class);
        Map<String, Teacher> map = student.getMap();
        Object[] array1 = map.values().toArray();
        Set<String> keys = map.keySet();
        Object[] array = keys.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] +" "+ array1[i]);
        }
        student.run();
    }
}
