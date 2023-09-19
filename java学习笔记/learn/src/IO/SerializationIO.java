package IO;

import java.io.*;

// 序列化流 /对象操作输出流 ObjectOutputStream，字节流的一种，用来输出数据，
// 同样的还有反序列化流 ObjectInputStream，字节流的一种，用来输入数据
public class SerializationIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化流的作用: 把类的对象写入本地文件中
        // 反序列化流的作用：在本地文件中读取类的对象

        // 1. 创建类的对象, 同时这个类要实现 Serialization 接口
        Student stu = new Student("zhangSan", 23, "北京");

        // 2. 创建序列化流的对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hello.txt"));

        // 3. 写出数据
        oos.writeObject(stu);

        // 4. 关闭数据流
        oos.close();

        // 反序列化流的使用
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hello.txt"));
        Student readStu = (Student) ois.readObject();
        System.out.println(readStu);    // 可以发现 address 并没有保存到文件中
        ois.close();
    }
}
