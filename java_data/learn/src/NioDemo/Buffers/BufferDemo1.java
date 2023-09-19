package NioDemo.Buffers;

import org.junit.Test;

import java.nio.ByteBuffer;

// 子缓冲区的使用
public class BufferDemo1 {
    @Test
    public void b01() {
        ByteBuffer buf = ByteBuffer.allocate(10);
        for (int i = 0; i < buf.capacity(); i++) {
            buf.put((byte)i);
        }
        // 创建子缓冲区
        buf.position(3);    // 设置开始位置
        buf.limit(7);         // 设置结束位置
        ByteBuffer sliceBuf = buf.slice();

        for (int i = 0; i < sliceBuf.capacity(); i++) {
            byte b = sliceBuf.get(i);   // 取出第 i 个位置的数据
            b *= 10;
            sliceBuf.put(i, b);         // 在第 i 个位置放入数据
        }
        // 还原标志位
        buf.position(0);
        buf.limit(buf.capacity());

        while (buf.hasRemaining()) {
            System.out.println(buf.get());
        }
    }
}
