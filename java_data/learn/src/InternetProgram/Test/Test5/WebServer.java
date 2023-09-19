package InternetProgram.Test.Test5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer implements Runnable{
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(Contact.PORT);
            Socket client;
            byte[] read_Id = new byte[1024];
            InputStream ips;
            OutputStream ops;

            client = serverSocket.accept();
            ips = client.getInputStream();
            ops = client.getOutputStream();
            ips.read(read_Id);
            DBUtils dbUtils = new DBUtils();
            dbUtils.dbConnect();
            System.out.println("Ω” ’µΩ" + read_Id[0]);
            String str = dbUtils.queryById(read_Id[0]);
            ops.write(str.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
