package AnnotationDemo.ReflectDemo;

import java.lang.reflect.Method;

@Pro(className = "AnnotationDemo.ReflectDemo.Demo1", methodName = "show")   // ��Ҫ����ʲôֻ��Ҫ�����ﴫ��Ķ��󼴿ɣ������޸Ĵ���
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        // 1. ����ע��
        // 1.1 ��ȡ������ֽ������ֶ���
        Class<ReflectDemo> currClazz = ReflectDemo.class;
        // 2.��ȡ�����ע�����
        Pro pro = currClazz.getAnnotation(Pro.class);   // ��ʵ�������ڴ���������һ����ע��ӿڵ�����ʵ�ֶ���
        /**
         * getAnnotation(Pro.class) �����൱��
         *
         * ����һ���࣬�����ȥ�̳� Pro �ӿڲ�ʵ������ķ���
         * public class ProImpl implements Pro {
         *     String className() {
         *          return "AnnotationDemo.ReflectDemo.Demo1";  // �㴫���ʲô�ͷ���ʲô
         *     }
         *     String methodName() {
         *          return "show";
         *     }
         * }
         */
        // 3.����ע������ж���ĳ��󷽷���ȡ����ֵ
        String className = pro.className();
        String methodName = pro.methodName();
        // 4.�����ȡ����ֵ����� Class ��
        Class<?> clazz = Class.forName(className);
        // ʹ��
        Demo1 demo = (Demo1) clazz.getDeclaredConstructor().newInstance();
        demo.show();
    }
}
