package NioDemo.Channels.FileChannels;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// FileChannel读取数据到 Buffer 中
public class FileChannelDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建 FileChannel
        FileInputStream aFile = new FileInputStream("hello.txt");
        // 通过 FileInputStream\FileOutputStream\RandomAccessFile类通过 getChannel()方法 创建 FileChannel对象
        FileChannel channel = aFile.getChannel();
        // 2. 创建 Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 3. 读取数据到缓冲区中
        int byteRead;
        while ((byteRead = channel.read(buf)) != -1) {
            System.out.println("------------读取到了"+ byteRead + "个数据--------");
            buf.flip();                 // 对 buf 进行读写转换，原来是 读，转换后是 写
            while (buf.hasRemaining()) { // 看 buf 里面的没有没剩余的数据
                System.out.print((char) buf.get());     // 取出缓冲区中的数据
            }
            buf.clear();    // 清空缓冲区
                            // 区别于 compact() 方法，compact()方法将缓冲区中未读的数据拷贝到 Buffer 起始处，limit设置为 capacity
        }
        aFile.close();
    }
}
