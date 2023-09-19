package IO;

import java.io.*;

/*
    IO，即 in和 out，也就是输入和输出，指应用程序和外部设备之间的数据传递，常见的外部设备包括文件、管道、网络连接。
    流（Stream），是一个抽象的概念，是指一连串的数据（字符或字节），是以先进先出的方式发送信息的通道。
    当程序需要读取数据的时候，就会开启一个通向数据源的流，这个数据源可以是文件，内存，或是网络连接。

 */
public class ByteIO
{
    // 非文本文件用字节流 - 因为非文本文件使用二进制存储的
    // 文本文件用字符流 - 例如：一个汉字表示两个字节，那么用字节流时可能会出现乱码
    public static void main(String[] args) {
        byte[] bytes = new byte[5];
        String s = null;
        try {
            // 造流
            FileInputStream fileInputStream = new FileInputStream("./src/IO/hello.txt");    // 两个字节表示一个汉字，所以打印汉字时可能会出现乱码
            FileOutputStream fos = new FileOutputStream("text.txt");
            // 读取文件中数据并写出
            while(fileInputStream.read(bytes) != -1)
            {
                s = new String(bytes).trim();   // new String() 会将中文的 两个字节劈开存储，可能出现乱码
                System.out.println(s);
                fos.write(bytes);       // 直接复制到文件中，不会出现乱码
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
