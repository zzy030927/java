package student.learn_java;
import java.util.Scanner;   // ������������


public class scanf {
    public static void main(String[] args)
    {
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();
        // nextLine() �� next() ���� nextLine()��ȡ���У� next() ��ȡ��һ���ո�֮ǰ������
        System.out.println(str);    // ������ݲ�����
        //  System.out.print(str);  // ������ݲ�����
        System.out.println("a height: ");
        int a = scr.nextInt();  // ��ȡһ�� int ���͵�ֵ
        System.out.println("b height: ");
        int b = scr.nextInt();
        System.out.println("c height: ");
        int c = scr.nextInt();
        int MaxHeight;
        MaxHeight = a > b ? a : b;
        MaxHeight = MaxHeight > c ? MaxHeight : c;
        System.out.println("maxHeight: " + MaxHeight);
    }
}
