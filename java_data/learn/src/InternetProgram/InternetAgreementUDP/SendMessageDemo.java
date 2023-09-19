package InternetProgram.InternetAgreementUDP;

import java.io.IOException;
import java.net.*;

// ͨ������Э�� UDP ��������
public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        // ��������

        // 1.���� DatagramSocket ����
        // �ղΣ����п��õĶ˿����һ������ʹ��
        // �вΣ�ָ���˿ںŽ��а�
        DatagramSocket socket = new DatagramSocket();

        // 2.�������
        String str = "Hello World!";
        byte[] bytes = str.getBytes();  // ���͵� byte ���͵�����

        InetAddress address = InetAddress.getByName("LAPTOP-ZZY");    // ���Ͷ˵� ip ��ַ
        int port = 10086;    // ��������ǽ��ն˵Ķ˿�
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);

        // 3.��������
        socket.send(packet);

        // 4.�ͷ���Դ
        socket.close();
    }
}
