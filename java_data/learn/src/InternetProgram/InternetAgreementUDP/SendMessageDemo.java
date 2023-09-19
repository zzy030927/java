package InternetProgram.InternetAgreementUDP;

import java.io.IOException;
import java.net.*;

// 通过网络协议 UDP 发送数据
public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        // 发送数据

        // 1.创建 DatagramSocket 对象
        // 空参：所有可用的端口随机一个进行使用
        // 有参：指定端口号进行绑定
        DatagramSocket socket = new DatagramSocket();

        // 2.打包数据
        String str = "Hello World!";
        byte[] bytes = str.getBytes();  // 发送的 byte 类型的数据

        InetAddress address = InetAddress.getByName("LAPTOP-ZZY");    // 发送端的 ip 地址
        int port = 10086;    // 这个参数是接收端的端口
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);

        // 3.发送数据
        socket.send(packet);

        // 4.释放资源
        socket.close();
    }
}
