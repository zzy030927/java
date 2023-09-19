package NioDemo.Selectors;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SelectorDemo2 {
    // 客户端代码
    @Test
    public void clientDemo() throws IOException {
        // 1. 获取通道，绑定主机和端口号
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        // 2. 切换到非阻塞模式
        socketChannel.configureBlocking(false);
        // 3. 创建 buffer, 写入数据
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(new Date().toString().getBytes());
        // 4. 写入通道，清空，关闭
        buf.flip();
        socketChannel.write(buf);
        buf.clear();
    }

    // 服务器端代码
    @Test
    public void serverDemo() throws IOException {
        // 1. 获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 2. 切换非阻塞状态
        serverSocketChannel.configureBlocking(false);
        // 3. 绑定端口号，做到监听的过程
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 4. 获取 Selector 选择器
        Selector selector = Selector.open();
        // 5. 通道注册到选择器中
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6. 选择器进行轮询操作，进行后续操作
        while (selector.select() > 0) {     // 有监听的事件处于就绪状态，等待通道的消息
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {      // 是否处于接收状态
                    // 获取连接
                    SocketChannel socket = serverSocketChannel.accept();
                    // 切换非阻塞模式
                    socket.configureBlocking(false);
                    // 注册
                    socket.register(selector, SelectionKey.OP_READ);    // 将返回的 socket 注册到 监听器中
                } else if (selectionKey.isReadable()) {  // 是否处于可读状态
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 读取数据
                    int len;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }
            }
            iterator.remove();
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 获取通道，绑定主机和端口号
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        // 2. 切换到非阻塞模式
        socketChannel.configureBlocking(false);
        // 3. 创建 buffer, 写入数据
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            buf.put((new Date() + "-->" + str).getBytes());
            // 4. 写入通道，清空，关闭
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
    }
}
