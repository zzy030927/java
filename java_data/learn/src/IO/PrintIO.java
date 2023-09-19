package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

// ��ӡ��
// ������ �ֽ������ PrintStream, �ַ������ PrintWriter
public class PrintIO {
    @Test
    public void test(){
        PrintStream ps = null;
        try {
            // �ֽ�������
            FileOutputStream fos = new FileOutputStream(new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt"));
            // �ֽ������
            ps = new PrintStream(fos, true);    // �ڶ�������Ϊ �Ƿ��Զ�ˢ�»�������д�뻻�з����� '\n' ʱˢ�»�������

            if (ps != null) {
                // �����λ�� �� ����̨ �ĵ� ps ��ָ��Ķ����У��� ����� "E:\\java\\java_data\\learn\\src\\IO\\hello.txt" ��
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) { // ��� ASCII �ַ�
                System.out.print((char) i);
                if (i % 50 == 0) {  // 50 ������һ��
                    System.out.println();   // ����
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
         // �ر���
            if(ps != null){
                ps.close();
            }
        }
    }
}
