package IO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

// ��׼���������
// ��׼�������� System.in     ����Ϊ InputStream, ���������ֽ��������ĸ���
// ��׼������� System.out    ����Ϊ PrintStream, �� OutputStream �����࣬���������ֽ�������ĸ���
public class InOutIO {
    // ��ϰ
    public static void main(String[] args){
        // �Ӽ��������ַ�����Ҫ�󽫶�ȡ���������ַ���ת��Ϊ��д�������Ȼ������������������ֱ�������� �� e �� ���� �� exit �� ʱ�˳�����
        // ���� 1�� Scanner()
        // ���� 2�� ʹ�������� System.in -> ת���� -> BufferedReader �� readLine()

        // ת����, InputStreamReader �Ĳ�����Ҫ����һ�� InputStream �Ĳ��������Դ��� System.in
        InputStreamReader isr = new InputStreamReader(System.in);
        // ����������Ҫ����һ�� Reader �Ĳ���
        BufferedReader br = new BufferedReader(isr);
        // �ӿ���̨��ȡ������
        String data;

        System.out.println("=======�������ַ���=======");
        while(true){
            // ��ȡһ������
            try {
                data = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // �ַ���������ǰ�������Ч�����ָ�������
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                System.out.println("�˳�����");
                break;
            }
            // ת����д
            String upperData = data.toUpperCase(Locale.ROOT);
            System.out.println(upperData);
        }
        // �ر���
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
