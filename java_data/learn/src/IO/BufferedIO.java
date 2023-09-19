package IO;

import java.io.*;

// 缓冲流提高速度的原因：内部提供了一个缓冲区
// 缓冲流：提高流的读写效率，有 BufferedInputStream,BufferedOutputStream 这是用来处理字节的
//                          BufferedReader,BufferedWriter 这是用来处理字符的
//  InputStream,OutputStream,FileReader,FileWriter 是作用在节点上的，所以这四个流也叫节点流
//  而 处理流 的作用是 “ 套接 ” 在已有流的基础上，这个流可以是节点流也可以是其他流。（缓冲流是处理流的一种）
public class BufferedIO
{
    public static void main(String[] args) {
        // 造文件
        File filename = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
        try {
            // 造字节流
            FileReader fileReader = new FileReader(filename);
            // 造缓冲流
            BufferedReader br = new BufferedReader(fileReader);
            while (true) {
                String str = br.readLine();
                if(str == null) break;
                System.out.println(str);
            // 资源关闭 : 先关闭外层的流，即 缓冲流
                //       再关闭内层的流，即 节点流
                // 但是 关闭外层流的同时，内层的流同时会关闭
            br.close();
            fileReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            // 造节点流
            FileWriter fw = new FileWriter(filename);
            // 造缓冲流
            BufferedWriter bw = new BufferedWriter(fw);
            String[] content = {"天气预报","大连","冰雹"};
            for(int i = 0; i < content.length; i++)
            {
                bw.write(content[i]);
                bw.newLine();
            }
            // 关闭流
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
