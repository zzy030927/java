import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class AcceptDataForUDP {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(3306);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        while(true){
            socket.receive(packet);
            byte[] data = packet.getData();
            String str = new String(data, 0, packet.getLength());
            if("886".equals(str)) break;
            System.out.println(str);
        }
        socket.close();
    }
}
