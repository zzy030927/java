package student.learn_java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date
{
    public static void main(String[] args)
    {
        // ����һ��Date�������������ڵ�ʱ��
        System.out.println("------����һ��Date()����------");
        Date nowTime = new Date();
        System.out.println("����ʱ��: " + nowTime);
        // Date�������Ϊ int ���ͣ���ô���صĲ���Ϊ 1970�� 1 �� 1 �� 8ʱ 0 �� 0�� + ����ĺ�����
        Date date = new Date(1000);
        System.out.println(date);
        // һ���ASC�ַ�Ҫ������
        System.out.println("------��ʽ��ʱ�� SimpleDateFormat()��-----");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'Now Time:' y��M��d��Hʱm��s��");   // ����һ����ʽ������
        String format = simpleDateFormat.format(nowTime);   // ��ʽ��ʱ�� nowTime
        System.out.println(format);
        // G = ��Ԫ E = ����
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("'Now Time:' Gyyyy��MM��EHHʱmm��ss��");
        String format1 = simpleDateFormat1.format(nowTime);
        System.out.println(format1);
        // ����ǰʱ��ת��Ϊ����
        System.out.println("-----��ʱ��ת��Ϊ����-----");
        long l = System.currentTimeMillis();    // ���ش� 1970�� 1 �� 1 �� 8ʱ 0 �� 0�� �����ڵĺ�����
        System.out.println("��"+simpleDateFormat.format(new Date(1000))+"�������ǣ�"+ l + "����");
    }
}
