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
    // �ͻ��˴���
    @Test
    public void clientDemo() throws IOException {
        // 1. ��ȡͨ�����������Ͷ˿ں�
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        // 2. �л���������ģʽ
        socketChannel.configureBlocking(false);
        // 3. ���� buffer, д������
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(new Date().toString().getBytes());
        // 4. д��ͨ������գ��ر�
        buf.flip();
        socketChannel.write(buf);
        buf.clear();
    }

    // �������˴���
    @Test
    public void serverDemo() throws IOException {
        // 1. ��ȡ�����ͨ��
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 2. �л�������״̬
        serverSocketChannel.configureBlocking(false);
        // 3. �󶨶˿ںţ����������Ĺ���
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 4. ��ȡ Selector ѡ����
        Selector selector = Selector.open();
        // 5. ͨ��ע�ᵽѡ������
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6. ѡ����������ѯ���������к�������
        while (selector.select() > 0) {     // �м������¼����ھ���״̬���ȴ�ͨ������Ϣ
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {      // �Ƿ��ڽ���״̬
                    // ��ȡ����
                    SocketChannel socket = serverSocketChannel.accept();
                    // �л�������ģʽ
                    socket.configureBlocking(false);
                    // ע��
                    socket.register(selector, SelectionKey.OP_READ);    // �����ص� socket ע�ᵽ ��������
                } else if (selectionKey.isReadable()) {  // �Ƿ��ڿɶ�״̬
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // ��ȡ����
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
        // 1. ��ȡͨ�����������Ͷ˿ں�
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        // 2. �л���������ģʽ
        socketChannel.configureBlocking(false);
        // 3. ���� buffer, д������
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            buf.put((new Date() + "-->" + str).getBytes());
            // 4. д��ͨ������գ��ر�
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
    }
}
