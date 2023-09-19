package NioDemo.Buffers;

import java.nio.ByteBuffer;

// 只读缓冲区的使用
public class BufferDemo2 {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(10);
        for (int i = 0; i < buf.capacity(); i++) {
            buf.put((byte)i);
        }

        // 创建只读缓冲区
        ByteBuffer onlyReadBuffer = buf.asReadOnlyBuffer();

        for (int i = 0; i < buf.capacity(); i++) {
            byte b = buf.get(i);
            b *= 10;
            buf.put(i, b);
        }

        onlyReadBuffer.position(0);
        onlyReadBuffer.limit(buf.capacity());

        // 只读缓冲区中的内容会跟着原缓冲区的内容进行变化
        while (onlyReadBuffer.hasRemaining()) {
            System.out.println(onlyReadBuffer.get());
        }
    }
}
