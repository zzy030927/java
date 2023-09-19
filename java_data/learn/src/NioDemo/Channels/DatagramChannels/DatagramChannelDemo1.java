package NioDemo.Channels.DatagramChannels;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class DatagramChannelDemo1 {

    // ���͵�ʵ��
    @Test
    public void sendDatagram() throws IOException, InterruptedException {
        // ��һ��ͨ��
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress sendAddress = new InetSocketAddress("127.0.0.1", 9999);

        // ����
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.wrap("12398561237551".getBytes("GBK"));
            sendChannel.send(byteBuffer, sendAddress);
            System.out.println("��ɷ���");
            Thread.sleep(2000);
        }
    }

    // ���ܵ�ʵ��
    @Test
    public void receiveDatagram() throws IOException {
        // �� DatagramChannel
        DatagramChannel receiveChannel = DatagramChannel.open();
        InetSocketAddress serverAddress = new InetSocketAddress(9999);
        // ��
        receiveChannel.bind(serverAddress);
        // ����
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (true) {
            buf.clear();
            SocketAddress receiveAddress = receiveChannel.receive(buf);
            buf.flip();
            System.out.println(receiveAddress.toString() + "�������");
            System.out.println(Charset.forName("GBK").decode(buf)); // ת�����뷽ʽΪ GBK
        }
    }

    // ��ʾ ���ӵ� read �� write ������������ read �� write ����֮ǰ����ʹ�� connect ������
    @Test
    public void testConnect() throws IOException, InterruptedException {
        // �� DatagramChannel
        DatagramChannel connChannel = DatagramChannel.open();
        InetSocketAddress connAddress = new InetSocketAddress(9999);
        // �󶨶˿�
        connChannel.bind(connAddress);
        // ����
        connChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
        // write����
        ByteBuffer writeBuffer = ByteBuffer.wrap("12398561237551".getBytes("GBK"));
        System.out.println("��������");
        connChannel.write(writeBuffer);
        Thread.sleep(2000);
        // read����
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        connChannel.read(readBuffer);
        readBuffer.flip();
        System.out.println(Charset.forName("GBK").decode(readBuffer));
        System.out.println("�������");
    }
}
