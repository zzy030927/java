package IO;

// ת����Ҳ�� ������ ͬʱҲ�� �ַ���
// ת������������ InputStreamReader, OutputStreamWriter

// InputStreamReader: ��һ���ֽڵ�������ת��Ϊ�ַ���������
// OutputStreamWriter: ��һ���ַ��������ת��Ϊ�ֽڵ������

// ����ʱ�� �ֽڡ��ֽ����� --> �ַ����顢�ַ����� ʹ�� InputStreamReader
// ����ʱ�� �ַ����顢�ַ��� --> �ֽڡ��ֽ����飬 ʹ�� OutputStreamWriter

import org.junit.Test;

import java.io.*;

public class TransIO {

    // InputStreamReader ��ʹ��
    @Test
    public void ByteToChar(){

        try {
            // �ֽ���
            FileInputStream fileInputStream = new FileInputStream("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
            // ת����
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                                                                        // �ڶ�������Ϊ �ļ���ʲô�ַ������ж�ȡ��Ĭ��Ϊϵͳ���õ��ַ���
                                                                        // ϵͳ���õ� GBK���� UTF-8 ���ж�ȡ�ᵼ������
            // ����ʵ��
            int len;
            char[] chars = new char[10];
            while( (len = inputStreamReader.read(chars)) != -1) {
                String str = new String(chars);
                System.out.println(str);
            }
            inputStreamReader.close();
        }
        catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    // �ۺ�ʹ�� InputStreamReader �� OutputStreamWriter
    @Test
    public void CharToByte(){

        // ����ת������ ����
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        // �����ļ�
        File readFile = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
        File writeFile = new File("E:\\java\\java_data\\learn\\hello.text");
        try {
            // �����ֽ���
            FileInputStream fis = new FileInputStream(readFile);
            FileOutputStream fos = new FileOutputStream(writeFile);
            // ����ת����
            isr = new InputStreamReader(fis, "gbk");  // gbk ���������
            osw = new OutputStreamWriter(fos, "utf-8");  // utf-8 д��ȥ
            // ��д����
            char[] chars = new char[20];
            int len;
            while( (len = isr.read(chars)) != -1){  // �ַ���������
                osw.write(chars, 0, len);       // �ֽ���д��ȥ
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            // �ر��ļ�
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
