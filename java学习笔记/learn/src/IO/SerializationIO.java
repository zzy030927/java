package IO;

import java.io.*;

// ���л��� /������������ ObjectOutputStream���ֽ�����һ�֣�����������ݣ�
// ͬ���Ļ��з����л��� ObjectInputStream���ֽ�����һ�֣�������������
public class SerializationIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // ���л���������: ����Ķ���д�뱾���ļ���
        // �����л��������ã��ڱ����ļ��ж�ȡ��Ķ���

        // 1. ������Ķ���, ͬʱ�����Ҫʵ�� Serialization �ӿ�
        Student stu = new Student("zhangSan", 23, "����");

        // 2. �������л����Ķ���
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hello.txt"));

        // 3. д������
        oos.writeObject(stu);

        // 4. �ر�������
        oos.close();

        // �����л�����ʹ��
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hello.txt"));
        Student readStu = (Student) ois.readObject();
        System.out.println(readStu);    // ���Է��� address ��û�б��浽�ļ���
        ois.close();
    }
}
