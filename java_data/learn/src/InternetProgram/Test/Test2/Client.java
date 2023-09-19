package InternetProgram.Test.Test2;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 10000);
        OutputStream ops = socket.getOutputStream();
        Scanner scr = new Scanner(System.in);
        String str = null;
        while(!"bye".equals(str)){
            str = scr.next();
            ops.write(str.getBytes());
        }
        socket.shutdownOutput();    // 设置停止输入标记
        InputStream ips = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(ips);
        int len;
        byte[] buf = new byte[1024];
        while((len = bis.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }
        bis.close();
        ops.close();
        socket.close();
    }
}
