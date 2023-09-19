package IO;
import java.io.*;

// 数据流：为了方便操作 java 中的基本数据类型和 String 我们可以使用数据流
public class DataIO
{
    public static void main(String[] args)
    {
        File filename = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            DataOutputStream outData = new DataOutputStream(fo);
            outData.writeInt(123);
            outData.writeChars("hello 12345");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi = new FileInputStream(filename);
            DataInputStream inData = new DataInputStream(fi);
            try {
                char a;
                System.out.println(inData.readInt());
                while((a = inData.readChar()) != '\0'){
                    System.out.print(a);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
