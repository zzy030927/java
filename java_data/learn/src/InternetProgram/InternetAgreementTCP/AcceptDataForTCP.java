package InternetProgram.InternetAgreementTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptDataForTCP {
    public static void main(String[] args) throws IOException {
        // 1. �ڱ��ص� ָ���˿� �������ȴ�����
        ServerSocket socket = new ServerSocket(9999);    // 999 �˿�û�б�ռ��
        System.out.println("�ȴ�����.....");
        // 2. ��û�пͻ������� ָ���˿�ʱ�� ������������ȴ�����
        // ��������ӣ���ô����һ�� Socket ����
        Socket acceptData = socket.accept();
        System.out.println("���ӳɹ�");
        // 3. ͨ�� socket.getInputStream() ��ȡ�ͻ���д�뵽����ͨ��������
        InputStream ips = acceptData.getInputStream();
        // ������
        BufferedInputStream bis = new BufferedInputStream(ips);
        byte[] buf = new byte[1024];
        int len;
        while((len = bis.read(buf)) != -1){
            String str = new String(buf, 0, len);
            System.out.println(str);
        }
        // 4.�ر���
        bis.close();
        socket.close();
    }
}
