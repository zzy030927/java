package IO;

import java.io.*;

// ����������ٶȵ�ԭ���ڲ��ṩ��һ��������
// ��������������Ķ�дЧ�ʣ��� BufferedInputStream,BufferedOutputStream �������������ֽڵ�
//                          BufferedReader,BufferedWriter �������������ַ���
//  InputStream,OutputStream,FileReader,FileWriter �������ڽڵ��ϵģ��������ĸ���Ҳ�нڵ���
//  �� ������ �������� �� �׽� �� ���������Ļ����ϣ�����������ǽڵ���Ҳ�����������������������Ǵ�������һ�֣�
public class BufferedIO
{
    public static void main(String[] args) {
        // ���ļ�
        File filename = new File("E:\\java\\java_data\\learn\\src\\IO\\hello.txt");
        try {
            // ���ֽ���
            FileReader fileReader = new FileReader(filename);
            // �컺����
            BufferedReader br = new BufferedReader(fileReader);
            while (true) {
                String str = br.readLine();
                if(str == null) break;
                System.out.println(str);
            // ��Դ�ر� : �ȹر����������� ������
                //       �ٹر��ڲ�������� �ڵ���
                // ���� �ر��������ͬʱ���ڲ����ͬʱ��ر�
            br.close();
            fileReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            // ��ڵ���
            FileWriter fw = new FileWriter(filename);
            // �컺����
            BufferedWriter bw = new BufferedWriter(fw);
            String[] content = {"����Ԥ��","����","����"};
            for(int i = 0; i < content.length; i++)
            {
                bw.write(content[i]);
                bw.newLine();
            }
            // �ر���
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
