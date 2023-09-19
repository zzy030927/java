package NioDemo.Buffers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// 直接缓冲区：使用一种特殊方式为其分配内存的缓冲区
// 目的：为了加快 I/O 速度
public class BufferDemo3 {
    public static void main(String[] args) throws IOException {
        String aFile = "hello.txt";
        FileInputStream fis = new FileInputStream(aFile);
        FileChannel readChannel = fis.getChannel();

        String bFile = "reader.txt";
        FileChannel writeChannel = new FileOutputStream(bFile).getChannel();

        // 创建直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

        while (true) {
            byteBuffer.clear();
            int read = readChannel.read(byteBuffer);    // 读取 a 文件中的内容到 缓冲区中
            if (read == -1)
                break;
            byteBuffer.flip();
            writeChannel.write(byteBuffer);             // 将 缓冲区 中的内容写出去
        }
        System.out.println("传输完毕");
    }
}
