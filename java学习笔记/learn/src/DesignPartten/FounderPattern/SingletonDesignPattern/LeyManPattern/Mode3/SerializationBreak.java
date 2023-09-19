package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode3;

import java.io.*;

// ���л��ƻ��������ģʽ
public class SerializationBreak {
    public static void main(String[] args) {
        writeObjectToFile();
        readObjectFromFile();
        readObjectFromFile();   // ��ַ����ͬ�����Կ����������ģʽ���ƻ�
    }

    // ���ļ���д���ݣ����󣩣������ǰ�һ������д��һ���ļ���
    public static void writeObjectToFile(){
        // 1.��ȡ Slob ����
        Slob instance = Slob.getInstance();
        // 2.�������������
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:\\java\\java_data\\learn\\text.txt"));
        // 3.д����
            oos.writeObject(instance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        // 4.�ر���
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    // ���ļ��ж����ݣ����󣩣������Ǵ�һ���ļ��ж���һ������
    public static void readObjectFromFile(){
        // 1. ��������������
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\java\\java_data\\learn\\text.txt"));
        // 2. ��ȡ����
            Slob instance = (Slob) ois.readObject();
            System.out.println(instance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
        // 3. �ر���
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
