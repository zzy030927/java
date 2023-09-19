package AnnotationDemo.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 当主方法执行后，会自动执行被检测的方法（加了 Check 注解的方法），判断方法是否否有异常，记录到日志文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        int number = 0;    // 记录出现错误的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\java\\java_data\\learn\\hello.txt"));
        // 1. 创建计算器对象
        Calculator cal = new Calculator();
        // 2. 获取字节码文件对象
        Class clazz = cal.getClass();
        // 3. 获取所有方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            // 4. 判断方法上是否有 Check 注解
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    // 5. 有，那么进行检查
                    method.invoke(cal);   // 用方法创建 cal 类的对象
                }
                // 6. 捕获异常，记录到文件中
                catch (Exception e) {
                    number++;
                    bw.write(method.getName() + "方法出现了异常");
                    bw.newLine();
                    bw.write("异常的名称: " + e.getCause().getClass().getSimpleName());
                    // e.getCause() 获取异常原因， .getClass() 获取这个方法的类，.getSimpleName()获取该类的简单类名：即不带包名
                    bw.newLine();
                    bw.write("异常的原因: " + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现" + number + "个异常");
        bw.flush();
        bw.close();
    }
}