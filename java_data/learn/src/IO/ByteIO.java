package IO;

import java.io.*;

/*
    IO���� in�� out��Ҳ��������������ָӦ�ó�����ⲿ�豸֮������ݴ��ݣ��������ⲿ�豸�����ļ����ܵ����������ӡ�
    ����Stream������һ������ĸ����ָһ���������ݣ��ַ����ֽڣ��������Ƚ��ȳ��ķ�ʽ������Ϣ��ͨ����
    ��������Ҫ��ȡ���ݵ�ʱ�򣬾ͻῪ��һ��ͨ������Դ�������������Դ�������ļ����ڴ棬�����������ӡ�

 */
public class ByteIO
{
    // ���ı��ļ����ֽ��� - ��Ϊ���ı��ļ�ʹ�ö����ƴ洢��
    // �ı��ļ����ַ��� - ���磺һ�����ֱ�ʾ�����ֽڣ���ô���ֽ���ʱ���ܻ��������
    public static void main(String[] args) {
        byte[] bytes = new byte[5];
        String s = null;
        try {
            // ����
            FileInputStream fileInputStream = new FileInputStream("./src/IO/hello.txt");    // �����ֽڱ�ʾһ�����֣����Դ�ӡ����ʱ���ܻ��������
            FileOutputStream fos = new FileOutputStream("text.txt");
            // ��ȡ�ļ������ݲ�д��
            while(fileInputStream.read(bytes) != -1)
            {
                s = new String(bytes).trim();   // new String() �Ὣ���ĵ� �����ֽ������洢�����ܳ�������
                System.out.println(s);
                fos.write(bytes);       // ֱ�Ӹ��Ƶ��ļ��У������������
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
