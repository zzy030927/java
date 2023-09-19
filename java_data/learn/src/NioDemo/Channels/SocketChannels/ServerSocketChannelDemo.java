package NioDemo.Channels.SocketChannels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // �˿ں�
        int port = 9999;

        // buffer
        ByteBuffer buf = ByteBuffer.wrap("123015".getBytes());  // �����ݷ���һ���ֽ�������

        // ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(port);
        ssc.bind(address);  // ��˿ڽ��а�

        // ���÷�����ģʽ
        ssc.configureBlocking(false);

        // �����Ƿ����µ����Ӵ���
        System.out.println("���ڵȴ����Ӵ���....");
        while (true) {
            SocketChannel sc = ssc.accept();    // û�����Ӵ���᷵�� null, ��Ϊ���ڷ�����ģʽ�£����Դ�������ִ����ȥ
            if (sc == null) {
                System.out.println("�ȴ�...");
                Thread.sleep(2000);
            } else {
                System.out.println(sc.socket().getRemoteSocketAddress() + "������");   // socket()��������һ�� Socket����
                buf.rewind();   // ָ��ص���ʼλ��
                sc.write(buf);  // ����д�뻺����
                sc.close();
                break;
            }
        }
    }
}
