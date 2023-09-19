package NioDemo.Channels.SocketChannels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        // ���� SocketChannel ����
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(9999));

        // �������ӷ���
        /*
            socketChannel.isOpen(); // �Ƿ�Ϊ open ״̬
            socketChannel.isConnected(); // �Ƿ�����
            socketChannel.isConnectionPending(); // �Ƿ���������
            socketChannel.finishConnect(); // �Ƿ��Ѿ��������
        */
        socketChannel.configureBlocking(false); // ������ģʽ

        ByteBuffer buf = ByteBuffer.allocate(16);
        socketChannel.read(buf);
        System.out.println(buf.get());
        socketChannel.close();
        System.out.println("��ȡ���");
    }
}
