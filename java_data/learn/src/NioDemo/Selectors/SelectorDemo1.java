package NioDemo.Selectors;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

// ���� Selector ѡ����
public class SelectorDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. ���� Selector ѡ����
        Selector selector = Selector.open();
        // 2. ע�� Channel �� Selector ����
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // ����ͨ��Ϊ������ģʽ��ֻ������ͨ��Ϊ������ģʽ������ӵ�ѡ��������
        serverSocketChannel.configureBlocking(false);
            // ������
        serverSocketChannel.bind(new InetSocketAddress(9999));
        System.out.println(serverSocketChannel.validOps()); // ��ѯ��ǰͨ���󶨵ļ������ɼ���ʲô�¼�
                                                            // 1 - READ , 4 - WRITE , 8 - CONNECT, 16 - ACCEPT
        // 3. ��ͨ��ע�ᵽѡ������
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);  // ���� ״̬

        // 4. ��ѯ��ѯ����״̬�Ĳ���
        Set<SelectionKey> selectionKeys = selector.selectedKeys();  // ���ͨ���Ѿ������ļ��ϲ���
            // �������ϵõ��ľ���ÿ���Ѿ������Ĳ���
        for (SelectionKey selectionKey : selectionKeys) {
            // �ж� key ����״̬�Ĳ���
            if (selectionKey.isAcceptable()) {

            } else if (selectionKey.isValid()) {

            } else if (selectionKey.isConnectable()) {

            } else if (selectionKey.isReadable()) {

            } else if (selectionKey.isWritable()) {

            }
        }
        // 5. ֹͣѡ��ķ��� : ѡ������ѡ��Ĺ����У�ϵͳ�ײ������ѯ��ÿ��ͨ���Ƿ��Ѿ�������������̿��ܻ���ɵ����߳̽�������״̬��
        //                  ��ô�����ַ��������� select() �������������߳�
        // wakeup() : ͨ������ Selector����� wakeup()�����ô�������״̬�� select() �������̷��ء�
        // close() :  ͨ�� close() ���� �ر� Selector��ʹ�� Selector ������ Channel ��ע�������еļ���ȡ�������� Channel ��������ر�

    }
}
