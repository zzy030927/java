package InternetProgram.GetInetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

// ��ȡ Ip ��ַ
public class MyInternetAddress {
    public static void main(String[] args) throws UnknownHostException {

        // ��ȡ������ InetAddress����
        // Ҳ���ǻ�ȡ IP �Ķ���
        InetAddress baidu = InetAddress.getByName("www.baidu.com");   // �ٶȵ�����
        InetAddress baidu1 = InetAddress.getByName("220.181.38.150"); // �ٶȵ� ip
        System.out.println("baidu = " +baidu);
        System.out.println("baiduIp = " +baidu1);
        InetAddress address = InetAddress.getByName("LAPTOP-ZZY");    // ���������� ip��ַ���˿ںţ���������
        InetAddress localHost = InetAddress.getLocalHost();                // ���ַ�ʽ��ȡ�� InetAddress ���� ������ͬ
        System.out.println("address = " +address);
        System.out.println("localHost = " +localHost);

        System.out.println("addressAddress = " +new String(localHost.getAddress().toString()));  // ���ֽ����� InetAddress����ĵ�ַ��Ҳ�����ڴ�ĵ�ַ
        System.out.println("localHostAddress = " +new String(address.getAddress().toString()));  // ���Կ��� InetAddress ����ĵ�ַ��ͬ, ��Ϊ���ǿ���������������ͬ���ڴ�ռ�
        String hostName = address.getHostName();                // ���ص�ǰ��ַ����������
        String hostName1 = localHost.getHostName();                // ���ص�ǰ��ַ����������
        System.out.println("addressName = " +hostName);
        System.out.println("localHostName = " + hostName1);

        String hostAddress = address.getHostAddress();          // �� String ���� ip ��ַ
        String hostAddress1 = localHost.getHostAddress();
        System.out.println("addressIp = " + hostAddress);
        System.out.println("localHostIp = " + hostAddress1);
    }
}
