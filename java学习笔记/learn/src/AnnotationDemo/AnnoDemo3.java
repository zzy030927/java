package AnnotationDemo;

import java.lang.annotation.*;

/**
 * 元注解使用方式 :
 * @Target:表示此注解的作用范围，常用可选项为：类、方法、变量
 * @Retention:表示此注解在什么时候起效，有三个选项。基本选择RUNTIME
 * @Documented:表示此注解是否被写入api文档中
 * @Inherited:表示此注解修饰的子类，是否能被继承
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})   // 表示 AnnoDemo3 这个注解只能作用于类，方法，成员变量上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnoDemo3 {

}
