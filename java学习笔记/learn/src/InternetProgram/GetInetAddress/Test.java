package InternetProgram.GetInetAddress;

import java.net.InetAddress;

public class Test {
    public static void main(String[] args) throws Exception {
        InetAddress localAddress = InetAddress.getLocalHost();
        InetAddress remoteAddress = InetAddress.getByName("192.168.222.116");
        System.out.println("本机的IP地址：" + localAddress.getHostAddress());
        System.out.println("itcast的IP地址：" + remoteAddress.getHostAddress());
        System.out.println("3秒是否可达：" + remoteAddress.isReachable(30000));
        System.out.println("itcast的主机名为：" + remoteAddress.getHostName());
    }

}
