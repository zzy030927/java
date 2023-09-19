package NioDemo.Channels.FileChannels;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// FileChannel��ȡ���ݵ� Buffer ��
public class FileChannelDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. ���� FileChannel
        FileInputStream aFile = new FileInputStream("hello.txt");
        // ͨ�� FileInputStream\FileOutputStream\RandomAccessFile��ͨ�� getChannel()���� ���� FileChannel����
        FileChannel channel = aFile.getChannel();
        // 2. ���� Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 3. ��ȡ���ݵ���������
        int byteRead;
        while ((byteRead = channel.read(buf)) != -1) {
            System.out.println("------------��ȡ����"+ byteRead + "������--------");
            buf.flip();                 // �� buf ���ж�дת����ԭ���� ����ת������ д
            while (buf.hasRemaining()) { // �� buf �����û��ûʣ�������
                System.out.print((char) buf.get());     // ȡ���������е�����
            }
            buf.clear();    // ��ջ�����
                            // ������ compact() ������compact()��������������δ�������ݿ����� Buffer ��ʼ����limit����Ϊ capacity
        }
        aFile.close();
    }
}
