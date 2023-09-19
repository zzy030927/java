package InternetProgram.InternetAgreementTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptDataForTCP {
    public static void main(String[] args) throws IOException {
        // 1. 在本地的 指定端口 监听，等待连接
        ServerSocket socket = new ServerSocket(9999);    // 999 端口没有被占用
        System.out.println("等待连接.....");
        // 2. 当没有客户端连接 指定端口时， 程序会阻塞，等待连接
        // 如果有连接，那么返回一个 Socket 对象
        Socket acceptData = socket.accept();
        System.out.println("连接成功");
        // 3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据
        InputStream ips = acceptData.getInputStream();
        // 缓冲流
        BufferedInputStream bis = new BufferedInputStream(ips);
        byte[] buf = new byte[1024];
        int len;
        while((len = bis.read(buf)) != -1){
            String str = new String(buf, 0, len);
            System.out.println(str);
        }
        // 4.关闭流
        bis.close();
        socket.close();
    }
}
