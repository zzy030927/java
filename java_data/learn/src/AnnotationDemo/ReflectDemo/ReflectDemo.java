package AnnotationDemo.ReflectDemo;

import java.lang.reflect.Method;

@Pro(className = "AnnotationDemo.ReflectDemo.Demo1", methodName = "show")   // 想要传入什么只需要改这里传入的对象即可，不用修改代码
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        // 1. 解析注解
        // 1.1 获取该类的字节码文字对象
        Class<ReflectDemo> currClazz = ReflectDemo.class;
        // 2.获取上面的注解对象
        Pro pro = currClazz.getAnnotation(Pro.class);   // 其实就是在内存中生成了一个该注解接口的子类实现对象
        /**
         * getAnnotation(Pro.class) 方法相当于
         *
         * 生成一个类，这个类去继承 Pro 接口并实现里面的方法
         * public class ProImpl implements Pro {
         *     String className() {
         *          return "AnnotationDemo.ReflectDemo.Demo1";  // 你传入的什么就返回什么
         *     }
         *     String methodName() {
         *          return "show";
         *     }
         * }
         */
        // 3.调用注解对象中定义的抽象方法获取返回值
        String className = pro.className();
        String methodName = pro.methodName();
        // 4.反射获取返回值对象的 Class 类
        Class<?> clazz = Class.forName(className);
        // 使用
        Demo1 demo = (Demo1) clazz.getDeclaredConstructor().newInstance();
        demo.show();
    }
}
