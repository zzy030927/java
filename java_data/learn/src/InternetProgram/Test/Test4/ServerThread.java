package InternetProgram.Test.Test4;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    static int count = 1;
    @Override
    public void run() {
        try {
            InputStream ips = socket.getInputStream();
            int len;
            byte[] buf = new byte[1024];
            File picture = new File("1.png");
            if(picture.exists())
                picture = new File(++count + ".png");
            FileOutputStream fos = new FileOutputStream(picture);
            while ((len = ips.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            OutputStream ops = socket.getOutputStream();
            ops.write("Ω” ’ÕÍ±œ".getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
