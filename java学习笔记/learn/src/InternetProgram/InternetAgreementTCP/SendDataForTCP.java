package InternetProgram.InternetAgreementTCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SendDataForTCP {
    private static Socket socket;

    public static void main(String[] args) throws IOException {
        // 1.���ӷ���ˣ�ip, �˿ڣ�
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 2.�����Ϻ����� Socket��ͨ�� Socket.getOutputStream()
        OutputStream ops = socket.getOutputStream();    // �õ��� socket ��������������
        // 3.ͨ���������д�����ݵ���Ϣͨ��
        ops.write("cnm".getBytes());
        System.out.println("���ͳɹ�");
        // 4.�ر����������Դ
        ops.close();
        socket.close();
    }
}

