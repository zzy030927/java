package IO;

// 转换流也是 处理流 同时也是 字符流
// 转换流有两个： InputStreamReader, OutputStreamWriter

// InputStreamReader: 将一个字节的输入流转换为字符的输入流
// OutputStreamWriter: 将一个字符的输出流转换为字节的输出流

// 解码时： 字节、字节数组 --> 字符数组、字符串， 使用 InputStreamReader
// 编码时： 字符数组、字符串 --> 字节、字节数组， 使用 OutputStreamWriter

import org.junit.Test;

import java.io.*;

public class TransIO {

    // InputStreamReader 的使用
    @Test
    public void ByteToChar(){

        try {
            // 字节流
            FileInputStream fileInputStream = new FileInputStream("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
            // 转换流
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                                                                        // 第二个参数为 文件用什么字符集进行读取，默认为系统设置的字符集
                                                                        // 系统设置的 GBK，用 UTF-8 进行读取会导致乱码
            // 具体实现
            int len;
            char[] chars = new char[10];
            while( (len = inputStreamReader.read(chars)) != -1) {
                String str = new String(chars);
                System.out.println(str);
            }
            inputStreamReader.close();
        }
        catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    // 综合使用 InputStreamReader 和 OutputStreamWriter
    @Test
    public void CharToByte(){

        // 创建转换流的 引用
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        // 创建文件
        File readFile = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
        File writeFile = new File("E:\\java\\java_data\\learn\\hello.text");
        try {
            // 创建字节流
            FileInputStream fis = new FileInputStream(readFile);
            FileOutputStream fos = new FileOutputStream(writeFile);
            // 创建转换流
            isr = new InputStreamReader(fis, "gbk");  // gbk 编码读进来
            osw = new OutputStreamWriter(fos, "utf-8");  // utf-8 写出去
            // 读写过程
            char[] chars = new char[20];
            int len;
            while( (len = isr.read(chars)) != -1){  // 字符流读进来
                osw.write(chars, 0, len);       // 字节流写出去
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            // 关闭文件
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
