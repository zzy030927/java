package NioDemo.Selectors;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

// 创建 Selector 选择器
public class SelectorDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建 Selector 选择器
        Selector selector = Selector.open();
        // 2. 注册 Channel 到 Selector 上面
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置通道为非阻塞模式，只有设置通道为非阻塞模式才能添加到选择器上面
        serverSocketChannel.configureBlocking(false);
            // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9999));
        System.out.println(serverSocketChannel.validOps()); // 查询当前通道绑定的监听器可监听什么事件
                                                            // 1 - READ , 4 - WRITE , 8 - CONNECT, 16 - ACCEPT
        // 3. 将通道注册到选择器中
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);  // 接受 状态

        // 4. 轮询查询就绪状态的操作
        Set<SelectionKey> selectionKeys = selector.selectedKeys();  // 多个通道已经就绪的集合操作
            // 遍历集合得到的就是每个已经就绪的操作
        for (SelectionKey selectionKey : selectionKeys) {
            // 判断 key 就绪状态的操作
            if (selectionKey.isAcceptable()) {

            } else if (selectionKey.isValid()) {

            } else if (selectionKey.isConnectable()) {

            } else if (selectionKey.isReadable()) {

            } else if (selectionKey.isWritable()) {

            }
        }
        // 5. 停止选择的方法 : 选择器在选择的过程中，系统底层会依次询问每个通道是否已经就绪，这个过程可能会造成调用线程进入阻塞状态，
        //                  那么有两种方法唤醒在 select() 方法中阻塞的线程
        // wakeup() : 通过调用 Selector对象的 wakeup()方法让处于阻塞状态的 select() 方法立刻返回。
        // close() :  通过 close() 方法 关闭 Selector，使该 Selector 的所有 Channel 被注销，所有的键被取消，但是 Channel 本身并不会关闭

    }
}
