package NioDemo.Pips;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

// �ܵ��������߳�֮��ĵ����������ӣ�Pipe��һ�� sink ͨ����һ�� source ͨ�������ݻᱻд�� sink ͨ���� �� sourceͨ����ȡ��
public class PipDemo {
    public static void main(String[] args) throws IOException {
        // 1. ��ȡ�ܵ�
        Pipe pipe = Pipe.open();
        // 2. ��ȡ sink ͨ�� �����ڴ��䣩
        Pipe.SinkChannel sink = pipe.sink();
        // 3. ����������
        ByteBuffer writeBuf = ByteBuffer.allocate(1024);
        writeBuf.put("123435568".getBytes());
        writeBuf.flip();
        // 4. ͨ�� sink ͨ��д������
        sink.write(writeBuf);
        System.out.println("�������");
        // 5. ��ȡ source ͨ��
        Pipe.SourceChannel source = pipe.source();
        // 6. ����������
        ByteBuffer readBuf = ByteBuffer.allocate(1024);
        // 7. ͨ�� source ͨ����������
        int length = source.read(readBuf);
        System.out.println(new String(readBuf.array(), 0, length) + "�������");
        // 8. �ر�ͨ��
        sink.close();
        source.close();
    }
}
