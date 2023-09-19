package InternetProgram.Test.Test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream ips = socket.getInputStream();
        File picture = new File("E:\\java\\java_data\\learn\\hello.webp");
        FileOutputStream fos = new FileOutputStream(picture);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] buf = new byte[1024];
        int len;
        while ((len = ips.read(buf)) != -1){
            bos.write(buf, 0, len);
        }
        OutputStream ops = socket.getOutputStream();
        ops.write(" ’µΩÕº∆¨".getBytes());
        socket.shutdownOutput();

        socket.close();
        serverSocket.close();
        bos.close();
        ips.close();
        ops.close();
    }
}
