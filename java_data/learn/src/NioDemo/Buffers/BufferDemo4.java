package NioDemo.Buffers;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

// 内存映射文件 I/O：直接基于内存进行读写，要比其他方式快很多
public class BufferDemo4 {
    public static void main(String[] args) throws IOException {
        int start = 0;
        int size = 1024;
        RandomAccessFile raf = new RandomAccessFile("hello.txt", "rw");
        FileChannel channel = raf.getChannel();
        // 内存映射操作
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, start, size);

        map.put(0, (byte) 97);
        map.put(1023, (byte) 103);
        System.out.println("传输完毕");
        raf.close();
    }
}
