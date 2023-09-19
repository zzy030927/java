package NioDemo.Channels.SocketChannels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        // 创建 SocketChannel 对象
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(9999));

        // 检验连接方法
        /*
            socketChannel.isOpen(); // 是否为 open 状态
            socketChannel.isConnected(); // 是否被连接
            socketChannel.isConnectionPending(); // 是否正在连接
            socketChannel.finishConnect(); // 是否已经完成连接
        */
        socketChannel.configureBlocking(false); // 非阻塞模式

        ByteBuffer buf = ByteBuffer.allocate(16);
        socketChannel.read(buf);
        System.out.println(buf.get());
        socketChannel.close();
        System.out.println("读取完毕");
    }
}
