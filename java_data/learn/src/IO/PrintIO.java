package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

// 打印流
// 两个： 字节输出流 PrintStream, 字符输出流 PrintWriter
public class PrintIO {
    @Test
    public void test(){
        PrintStream ps = null;
        try {
            // 字节输入流
            FileOutputStream fos = new FileOutputStream(new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt"));
            // 字节输出流
            ps = new PrintStream(fos, true);    // 第二个参数为 是否自动刷新缓冲区（写入换行符或者 '\n' 时刷新缓冲区）

            if (ps != null) {
                // 将输出位置 从 控制台 改到 ps 所指向的对象中，即 输出到 "E:\\java\\java_data\\learn\\src\\IO\\hello.txt" 中
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) { // 输出 ASCII 字符
                System.out.print((char) i);
                if (i % 50 == 0) {  // 50 个数据一行
                    System.out.println();   // 换行
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
         // 关闭流
            if(ps != null){
                ps.close();
            }
        }
    }
}
