package NioDemo.Channels.DatagramChannels;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class DatagramChannelDemo1 {

    // 发送的实现
    @Test
    public void sendDatagram() throws IOException, InterruptedException {
        // 打开一个通道
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress sendAddress = new InetSocketAddress("127.0.0.1", 9999);

        // 发送
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.wrap("12398561237551".getBytes("GBK"));
            sendChannel.send(byteBuffer, sendAddress);
            System.out.println("完成发送");
            Thread.sleep(2000);
        }
    }

    // 接受的实现
    @Test
    public void receiveDatagram() throws IOException {
        // 打开 DatagramChannel
        DatagramChannel receiveChannel = DatagramChannel.open();
        InetSocketAddress serverAddress = new InetSocketAddress(9999);
        // 绑定
        receiveChannel.bind(serverAddress);
        // 接受
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (true) {
            buf.clear();
            SocketAddress receiveAddress = receiveChannel.receive(buf);
            buf.flip();
            System.out.println(receiveAddress.toString() + "接收完成");
            System.out.println(Charset.forName("GBK").decode(buf)); // 转换编码方式为 GBK
        }
    }

    // 演示 连接的 read 和 write 方法，（调用 read 和 write 方法之前必须使用 connect 方法）
    @Test
    public void testConnect() throws IOException, InterruptedException {
        // 打开 DatagramChannel
        DatagramChannel connChannel = DatagramChannel.open();
        InetSocketAddress connAddress = new InetSocketAddress(9999);
        // 绑定端口
        connChannel.bind(connAddress);
        // 连接
        connChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
        // write方法
        ByteBuffer writeBuffer = ByteBuffer.wrap("12398561237551".getBytes("GBK"));
        System.out.println("发送数据");
        connChannel.write(writeBuffer);
        Thread.sleep(2000);
        // read方法
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        connChannel.read(readBuffer);
        readBuffer.flip();
        System.out.println(Charset.forName("GBK").decode(readBuffer));
        System.out.println("接收完成");
    }
}
