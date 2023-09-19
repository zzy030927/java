package InternetProgram.InternetAgreementUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

// UDP ��������
public class AcceptMessageDemo {
    public static void main(String[] args) throws IOException {

        // 1. ���� DatagramSocket ����
        DatagramSocket socket = new DatagramSocket(10086);   // ����ʱ�󶨵Ķ˿ںͷ��͵Ķ˿�Ҫ����һ��

        // 2. �������ݰ�
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);     // �����͵����ݽ��յ�����

        // 3. �������ݰ�
        byte[] data = packet.getData();
        InetAddress address = packet.getAddress();  // ���Ͷ˵� ip
        int length = packet.getLength();            // ���ݳ���
        int port = packet.getPort();                // ���Ͷ˵� �˿�
        System.out.println("���ܵ������ݣ�" + new String(data, 0, length) +
                           " ���ݳ��ȣ�" + length +
                           " ���Ͷ˵�ip��" + address +
                           " ���Ͷ˵Ķ˿ڣ�" + port);
        // 4. �ͷ���Դ
        socket.close();

        // ϸ�ڣ������н��ն� �����з��Ͷ�

    }
}
