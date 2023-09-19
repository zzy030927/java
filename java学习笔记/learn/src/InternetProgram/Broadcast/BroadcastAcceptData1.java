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
        InetAddress address = packet.getAddress();  // 发送端的 ip
        int length = packet.getLength();            // 数据长度
        int port = packet.getPort();                // 发送端的 端口
        System.out.println("接受到的数据：" + new String(data, 0, length) +
                " 数据长度：" + length +
                " 发送端的ip：" + address +
                " 发送端的端口：" + port);
        // 4. 释放资源
        socket.close();

    }
}
