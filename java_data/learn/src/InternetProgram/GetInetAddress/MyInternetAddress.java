package InternetProgram.GetInetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 获取 Ip 地址
public class MyInternetAddress {
    public static void main(String[] args) throws UnknownHostException {

        // 获取本机的 InetAddress对象
        // 也就是获取 IP 的对象
        InetAddress baidu = InetAddress.getByName("www.baidu.com");   // 百度的域名
        InetAddress baidu1 = InetAddress.getByName("220.181.38.150"); // 百度的 ip
        System.out.println("baidu = " +baidu);
        System.out.println("baiduIp = " +baidu1);
        InetAddress address = InetAddress.getByName("LAPTOP-ZZY");    // 参数可以是 ip地址，端口号，电脑名字
        InetAddress localHost = InetAddress.getLocalHost();                // 两种方式获取的 InetAddress 对象 内容相同
        System.out.println("address = " +address);
        System.out.println("localHost = " +localHost);

        System.out.println("addressAddress = " +new String(localHost.getAddress().toString()));  // 用字节数组 InetAddress对象的地址，也就是内存的地址
        System.out.println("localHostAddress = " +new String(address.getAddress().toString()));  // 可以看到 InetAddress 对象的地址不同, 因为它是开辟了两块内容相同的内存空间
        String hostName = address.getHostName();                // 返回当前地址主机的名字
        String hostName1 = localHost.getHostName();                // 返回当前地址主机的名字
        System.out.println("addressName = " +hostName);
        System.out.println("localHostName = " + hostName1);

        String hostAddress = address.getHostAddress();          // 用 String 接受 ip 地址
        String hostAddress1 = localHost.getHostAddress();
        System.out.println("addressIp = " + hostAddress);
        System.out.println("localHostIp = " + hostAddress1);
    }
}
