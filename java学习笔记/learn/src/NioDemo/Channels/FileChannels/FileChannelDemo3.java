package NioDemo.Channels.FileChannels;

//    FileChannel ��� position() ��������ȡ FileChannel ��ǰ��λ��
//                    position(long pos) ���������� FileChannel ��ǰ��λ��
//                    size() �����������ļ��Ĵ�С
//                    truncate(long size) ��������ȡһ���ļ����ļ� size λ�ú�����ݻᱻɾ��
//                    force() ��������ͨ������δд�뵽Ӳ���е�����ǿ��д�뵽Ӳ����
//                    transferTo(), transferFrom()����������ͨ��֮������ݴ��䣬��һ��ͨ���е�����д�뵽��һ��ͨ����

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelDemo3 {
    public static void main(String[] args) throws IOException {
        // �������� FileChannel
        RandomAccessFile aFile = new RandomAccessFile("hello.txt", "rw");
        FileChannel fromChannel = aFile.getChannel();

        RandomAccessFile bFile = new RandomAccessFile("reader.txt", "rw");
        FileChannel toChannel = bFile.getChannel();

        // fromChannel �е����� ���뵽 toChannel ��ȥ
        toChannel.transferFrom(fromChannel, 0, fromChannel.size());
//       ��ͬ�� fromChannel.transferTo(0, fromChannel.size(), toChannel);

        aFile.close();
        bFile.close();
        System.out.println("�������");
    }
}
