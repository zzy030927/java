package InternetProgram.Test.Test2;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("�ȴ�����...");
        Socket socket = serverSocket.accept();
        System.out.println("���ӳɹ�,��ʼ����...");

        InputStream ips = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(ips);
        int len;
        byte[] buf = new byte[1024];
        while((len = bis.read(buf)) != -1){
            String str = new String(buf, 0, len);
            System.out.println(str);
        }

        OutputStream ops = socket.getOutputStream();
        ops.write("���յ�".getBytes());
        socket.shutdownOutput();    // ����ֹͣ������
        ops.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
