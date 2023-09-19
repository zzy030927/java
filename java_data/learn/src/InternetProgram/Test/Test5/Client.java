package InternetProgram.Test.Test5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket client;

    public static void main(String[] args) {
        try {
            Scanner scr = new Scanner(System.in);
            OutputStream ops;
            InputStream ips;

            client = new Socket(InetAddress.getLocalHost(), Contact.PORT);
            ops = client.getOutputStream();
            ips = client.getInputStream();
            int id = scr.nextInt();
            ops.write(id);
            System.out.println("ÒÑ·¢ËÍ" + id);
            byte[] buf = new byte[1024];
            int len;
            while ((len = ips.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
