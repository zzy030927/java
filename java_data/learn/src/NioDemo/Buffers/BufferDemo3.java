package NioDemo.Buffers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// ֱ�ӻ�������ʹ��һ�����ⷽʽΪ������ڴ�Ļ�����
// Ŀ�ģ�Ϊ�˼ӿ� I/O �ٶ�
public class BufferDemo3 {
    public static void main(String[] args) throws IOException {
        String aFile = "hello.txt";
        FileInputStream fis = new FileInputStream(aFile);
        FileChannel readChannel = fis.getChannel();

        String bFile = "reader.txt";
        FileChannel writeChannel = new FileOutputStream(bFile).getChannel();

        // ����ֱ�ӻ�����
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

        while (true) {
            byteBuffer.clear();
            int read = readChannel.read(byteBuffer);    // ��ȡ a �ļ��е����ݵ� ��������
            if (read == -1)
                break;
            byteBuffer.flip();
            writeChannel.write(byteBuffer);             // �� ������ �е�����д��ȥ
        }
        System.out.println("�������");
    }
}
