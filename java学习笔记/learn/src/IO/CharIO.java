package IO;
import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// FileReader 字符流读取
// 所有字符输入流的父类 Reader
// 所有字符输出流的父类 Writer
public class CharIO {
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            // 造文件
            File file = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");     // 绝对路径
            // 造流
            fr = new FileReader(file);
            // 数据读入
            int data = fr.read();   // 返回一个 int 类型的数据，data = -1，那么就代表读取结束
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 对 read() 操作的升级：使用 read 的重载方法
    @Test
    public void testFileReader1() throws IOException {
        FileReader fr = null;
        try {
            File file = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
            fr = new FileReader(file);
            char[] chars = new char[5];
            int read = fr.read(chars);// 每次最多读取 chars长度 个字节的数据，把它放入 chars 数组中，返回值为读取字节的个数,为空返回 -1
            while (read != -1) {
                for (int i = 0; i < read; i++)      // 长度不能为 chars.length，因为写入数组时是覆盖形式的，当最后长度不够 5 时，有几个字节不会被覆盖
                    System.out.print(chars[i]);
                read = fr.read(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

