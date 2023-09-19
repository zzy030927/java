package InternetProgram.Test.Test1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendDataForUDP {
    public static void main(String[] args) throws IOException {
        // 发送端不断发送数据，直送发送至 886 结束，接收端也始终接受数据
        Scanner scanner = new Scanner(System.in);
        String data;
        DatagramSocket socket = null;
        while(true){
            data = scanner.next();
            if("886".equals(data))
                break;
            socket = new DatagramSocket();
            byte[] buf = data.getBytes();
            InetAddress address = InetAddress.getByName("LAPTOP-ZZY");
            int port = 10000;
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
        }

        socket.close();
    }
}
