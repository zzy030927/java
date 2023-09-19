package IO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

// 标准输入输出流
// 标准输入流： System.in     类型为 InputStream, 它是所有字节输入流的父类
// 标准输出流： System.out    类型为 PrintStream, 是 OutputStream 的子类，它是所有字节输出流的父类
public class InOutIO {
    // 练习
    public static void main(String[] args){
        // 从键盘输入字符串，要求将读取到的整行字符串转换为大写并输出，然后继续进行输入操作，直到当输入 “ e ” 或者 “ exit ” 时退出程序
        // 方法 1： Scanner()
        // 方法 2： 使用输入流 System.in -> 转换流 -> BufferedReader 的 readLine()

        // 转换流, InputStreamReader 的参数需要传入一个 InputStream 的参数，所以传入 System.in
        InputStreamReader isr = new InputStreamReader(System.in);
        // 缓存流，需要传入一个 Reader 的参数
        BufferedReader br = new BufferedReader(isr);
        // 从控制台读取的数据
        String data;

        System.out.println("=======请输入字符串=======");
        while(true){
            // 读取一行数据
            try {
                data = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 字符串常量放前面可以有效避免空指针的问题
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                System.out.println("退出程序");
                break;
            }
            // 转换大写
            String upperData = data.toUpperCase(Locale.ROOT);
            System.out.println(upperData);
        }
        // 关闭流
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
