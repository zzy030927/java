package NioDemo.Buffers;

import org.junit.Test;

import java.nio.ByteBuffer;

// �ӻ�������ʹ��
public class BufferDemo1 {
    @Test
    public void b01() {
        ByteBuffer buf = ByteBuffer.allocate(10);
        for (int i = 0; i < buf.capacity(); i++) {
            buf.put((byte)i);
        }
        // �����ӻ�����
        buf.position(3);    // ���ÿ�ʼλ��
        buf.limit(7);         // ���ý���λ��
        ByteBuffer sliceBuf = buf.slice();

        for (int i = 0; i < sliceBuf.capacity(); i++) {
            byte b = sliceBuf.get(i);   // ȡ���� i ��λ�õ�����
            b *= 10;
            sliceBuf.put(i, b);         // �ڵ� i ��λ�÷�������
        }
        // ��ԭ��־λ
        buf.position(0);
        buf.limit(buf.capacity());

        while (buf.hasRemaining()) {
            System.out.println(buf.get());
        }
    }
}
