package student.learn_java;
import java.util.Scanner;   // 输入流包导入


public class scanf {
    public static void main(String[] args)
    {
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();
        // nextLine() 与 next() 区别： nextLine()读取整行， next() 读取第一个空格之前的内容
        System.out.println(str);    // 输出内容并换行
        //  System.out.print(str);  // 输出内容不换行
        System.out.println("a height: ");
        int a = scr.nextInt();  // 读取一个 int 类型的值
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
