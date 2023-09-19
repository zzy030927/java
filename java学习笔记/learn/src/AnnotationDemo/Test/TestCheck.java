package AnnotationDemo.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * �򵥵Ĳ��Կ��
 * ��������ִ�к󣬻��Զ�ִ�б����ķ��������� Check ע��ķ��������жϷ����Ƿ�����쳣����¼����־�ļ���
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        int number = 0;    // ��¼���ִ���Ĵ���
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\java\\java_data\\learn\\hello.txt"));
        // 1. ��������������
        Calculator cal = new Calculator();
        // 2. ��ȡ�ֽ����ļ�����
        Class clazz = cal.getClass();
        // 3. ��ȡ���з���
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            // 4. �жϷ������Ƿ��� Check ע��
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    // 5. �У���ô���м��
                    method.invoke(cal);   // �÷������� cal ��Ķ���
                }
                // 6. �����쳣����¼���ļ���
                catch (Exception e) {
                    number++;
                    bw.write(method.getName() + "�����������쳣");
                    bw.newLine();
                    bw.write("�쳣������: " + e.getCause().getClass().getSimpleName());
                    // e.getCause() ��ȡ�쳣ԭ�� .getClass() ��ȡ����������࣬.getSimpleName()��ȡ����ļ�����������������
                    bw.newLine();
                    bw.write("�쳣��ԭ��: " + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("���β���һ������" + number + "���쳣");
        bw.flush();
        bw.close();
    }
}