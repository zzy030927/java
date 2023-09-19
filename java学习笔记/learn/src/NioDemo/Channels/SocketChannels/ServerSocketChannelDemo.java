package NioDemo.Channels.SocketChannels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 端口号
        int port = 9999;

        // buffer
        ByteBuffer buf = ByteBuffer.wrap("123015".getBytes());  // 将内容放入一个字节数组中

        // ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(port);
        ssc.bind(address);  // 与端口进行绑定

        // 设置非阻塞模式
        ssc.configureBlocking(false);

        // 监听是否有新的连接传入
        System.out.println("正在等待连接传入....");
        while (true) {
            SocketChannel sc = ssc.accept();    // 没有连接传入会返回 null, 因为是在非阻塞模式下，所以代码会继续执行下去
            if (sc == null) {
                System.out.println("等待...");
                Thread.sleep(2000);
            } else {
                System.out.println(sc.socket().getRemoteSocketAddress() + "已连接");   // socket()方法返回一个 Socket对象
                buf.rewind();   // 指针回到开始位置
                sc.write(buf);  // 数据写入缓冲区
                sc.close();
                break;
            }
        }
    }
}
