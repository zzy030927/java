package IO;
import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// FileReader �ַ�����ȡ
// �����ַ��������ĸ��� Reader
// �����ַ�������ĸ��� Writer
public class CharIO {
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            // ���ļ�
            File file = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");     // ����·��
            // ����
            fr = new FileReader(file);
            // ���ݶ���
            int data = fr.read();   // ����һ�� int ���͵����ݣ�data = -1����ô�ʹ����ȡ����
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر���
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // �� read() ������������ʹ�� read �����ط���
    @Test
    public void testFileReader1() throws IOException {
        FileReader fr = null;
        try {
            File file = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
            fr = new FileReader(file);
            char[] chars = new char[5];
            int read = fr.read(chars);// ÿ������ȡ chars���� ���ֽڵ����ݣ��������� chars �����У�����ֵΪ��ȡ�ֽڵĸ���,Ϊ�շ��� -1
            while (read != -1) {
                for (int i = 0; i < read; i++)      // ���Ȳ���Ϊ chars.length����Ϊд������ʱ�Ǹ�����ʽ�ģ�����󳤶Ȳ��� 5 ʱ���м����ֽڲ��ᱻ����
                    System.out.print(chars[i]);
                read = fr.read(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

