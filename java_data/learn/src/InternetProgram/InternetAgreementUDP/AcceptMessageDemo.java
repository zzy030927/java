package InternetProgram.InternetAgreementUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

// UDP 接受数据
public class AcceptMessageDemo {
    public static void main(String[] args) throws IOException {

        // 1. 建立 DatagramSocket 对象
        DatagramSocket socket = new DatagramSocket(10086);   // 接受时绑定的端口和发送的端口要保持一致

        // 2. 接受数据包
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);     // 将发送的数据接收到包中

        // 3. 解析数据包
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

        // 细节：先运行接收端 先运行发送端

    }
}
