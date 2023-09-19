package InternetProgram.Broadcast;

import java.io.IOException;
import java.net.*;

public class BroadcastSendData {
    public static void main(String[] args) throws IOException {

        String str = "Hello World!";
        byte[] bytes = str.getBytes();

        InetAddress address = InetAddress.getByName("224.0.0.1");    //π„≤•µÿ÷∑
        MulticastSocket multicastSocket = new MulticastSocket();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 10086);
        multicastSocket.send(packet);

        multicastSocket.close();
    }
}
