package NioDemo.Buffers;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

// �ڴ�ӳ���ļ� I/O��ֱ�ӻ����ڴ���ж�д��Ҫ��������ʽ��ܶ�
public class BufferDemo4 {
    public static void main(String[] args) throws IOException {
        int start = 0;
        int size = 1024;
        RandomAccessFile raf = new RandomAccessFile("hello.txt", "rw");
        FileChannel channel = raf.getChannel();
        // �ڴ�ӳ�����
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, start, size);

        map.put(0, (byte) 97);
        map.put(1023, (byte) 103);
        System.out.println("�������");
        raf.close();
    }
}
