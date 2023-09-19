package InternetProgram.InternetAgreementTCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SendDataForTCP {
    private static Socket socket;

    public static void main(String[] args) throws IOException {
        // 1.连接服务端（ip, 端口）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 2.连接上后，生成 Socket，通过 Socket.getOutputStream()
        OutputStream ops = socket.getOutputStream();    // 得到和 socket 对象关联的输出流
        // 3.通过输出流，写入数据到信息通道
        ops.write("cnm".getBytes());
        System.out.println("发送成功");
        // 4.关闭流和相关资源
        ops.close();
        socket.close();
    }
}

