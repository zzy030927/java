package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode3;

import java.io.*;

// 序列化破坏单例设计模式
public class SerializationBreak {
    public static void main(String[] args) {
        writeObjectToFile();
        readObjectFromFile();
        readObjectFromFile();   // 地址不相同，可以看出单例设计模式被破坏
    }

    // 向文件中写数据（对象）：这里是把一个对象写入一个文件中
    public static void writeObjectToFile(){
        // 1.获取 Slob 对象
        Slob instance = Slob.getInstance();
        // 2.创建输出流对象
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:\\java\\java_data\\learn\\text.txt"));
        // 3.写对象
            oos.writeObject(instance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        // 4.关闭流
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    // 从文件中读数据（对象）：这里是从一个文件中读入一个对象
    public static void readObjectFromFile(){
        // 1. 创建对象输入流
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\java\\java_data\\learn\\text.txt"));
        // 2. 读取对象
            Slob instance = (Slob) ois.readObject();
            System.out.println(instance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
        // 3. 关闭流
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
