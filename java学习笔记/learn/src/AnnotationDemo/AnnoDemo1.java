package AnnotationDemo;

public @interface AnnoDemo1 {
    int age();            // �൱�ڳ��󷽷���Ĭ��Ϊ public abstract
    AnnoDemo2 anno();     // ע������
    Class st();
    String str();
    Person p();           // ö������
    int[] arr();
}
