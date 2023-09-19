package student.learn_java;

public class method // 自定义的方法在类里定义,不能在类外定义
{

    public static void main(String[] args)
    {
        int a = 3, b = 5, c;
        c = swap(a, b);
        System.out.println(c);
    }

    private static int swap(int a, int b)    // 在本类里 private、protected、public可以都被访问
    {
        if (a > b) return a;
        else return b;
    }
}