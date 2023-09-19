package InternetProgram.Test.Test4;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        int len;
        Socket socket = new Socket("127.0.0.1", 10000);
        byte[] buf = new byte[1024];
        FileInputStream fis;
        File picture = new File("E:\\java\\java_data\\learn\\hello.webp");
        fis = new FileInputStream(picture);
        OutputStream ops = socket.getOutputStream();
        while ((len = fis.read(buf)) != -1)
            ops.write(buf, 0, len);
        socket.shutdownOutput();

        InputStream ips = socket.getInputStream();
        while((len = ips.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }
        socket.close();
        ops.close();
        ips.close();
    }
}
