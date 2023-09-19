package NioDemo.Pips;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

// 管道：两个线程之间的单向数据连接，Pipe有一个 sink 通道和一个 source 通道，数据会被写道 sink 通道， 从 source通道读取。
public class PipDemo {
    public static void main(String[] args) throws IOException {
        // 1. 获取管道
        Pipe pipe = Pipe.open();
        // 2. 获取 sink 通道 （用于传输）
        Pipe.SinkChannel sink = pipe.sink();
        // 3. 创建缓冲区
        ByteBuffer writeBuf = ByteBuffer.allocate(1024);
        writeBuf.put("123435568".getBytes());
        writeBuf.flip();
        // 4. 通过 sink 通道写入数据
        sink.write(writeBuf);
        System.out.println("传输完成");
        // 5. 获取 source 通道
        Pipe.SourceChannel source = pipe.source();
        // 6. 创建缓冲区
        ByteBuffer readBuf = ByteBuffer.allocate(1024);
        // 7. 通过 source 通道读入数据
        int length = source.read(readBuf);
        System.out.println(new String(readBuf.array(), 0, length) + "接受完成");
        // 8. 关闭通道
        sink.close();
        source.close();
    }
}
