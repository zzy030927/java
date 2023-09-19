package AnnotationDemo;

public @interface AnnoDemo1 {
    int age();            // 相当于抽象方法，默认为 public abstract
    AnnoDemo2 anno();     // 注解类型
    Class st();
    String str();
    Person p();           // 枚举类型
    int[] arr();
}
