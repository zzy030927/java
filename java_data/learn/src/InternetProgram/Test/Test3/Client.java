package InternetProgram.Test.Test3;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        File picture = new File("C:\\Users\\lenovo\\Pictures\\∆Û“µ.png");
        OutputStream ops = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(picture);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1){
            ops.write(buf, 0, len);
        }
        socket.shutdownOutput();

        InputStream ips = socket.getInputStream();
        while((len = ips.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }

        socket.close();
        ops.close();
        ips.close();
        bis.close();
    }
}
