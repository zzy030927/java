package NioDemo.Buffers;

import java.nio.ByteBuffer;

// ֻ����������ʹ��
public class BufferDemo2 {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(10);
        for (int i = 0; i < buf.capacity(); i++) {
            buf.put((byte)i);
        }

        // ����ֻ��������
        ByteBuffer onlyReadBuffer = buf.asReadOnlyBuffer();

        for (int i = 0; i < buf.capacity(); i++) {
            byte b = buf.get(i);
            b *= 10;
            buf.put(i, b);
        }

        onlyReadBuffer.position(0);
        onlyReadBuffer.limit(buf.capacity());

        // ֻ���������е����ݻ����ԭ�����������ݽ��б仯
        while (onlyReadBuffer.hasRemaining()) {
            System.out.println(onlyReadBuffer.get());
        }
    }
}
