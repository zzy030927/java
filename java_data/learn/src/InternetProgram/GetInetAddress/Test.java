package InternetProgram.GetInetAddress;

import java.net.InetAddress;

public class Test {
    public static void main(String[] args) throws Exception {
        InetAddress localAddress = InetAddress.getLocalHost();
        InetAddress remoteAddress = InetAddress.getByName("192.168.222.116");
        System.out.println("������IP��ַ��" + localAddress.getHostAddress());
        System.out.println("itcast��IP��ַ��" + remoteAddress.getHostAddress());
        System.out.println("3���Ƿ�ɴ" + remoteAddress.isReachable(30000));
        System.out.println("itcast��������Ϊ��" + remoteAddress.getHostName());
    }

}
