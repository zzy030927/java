package InternetProgram.Broadcast;

import java.io.IOException;
import java.net.*;

public class BroadcastAcceptData1 {
    public static void main(String[] args) throws IOException {
        InetAddress group = InetAddress.getByName("224.0.0.1");
        MulticastSocket socket = new MulticastSocket(10086);
        socket.joinGroup(group);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

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

    }
}
