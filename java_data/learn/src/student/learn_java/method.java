package student.learn_java;

public class method // �Զ���ķ��������ﶨ��,���������ⶨ��
{

    public static void main(String[] args)
    {
        int a = 3, b = 5, c;
        c = swap(a, b);
        System.out.println(c);
    }

    private static int swap(int a, int b)    // �ڱ����� private��protected��public���Զ�������
    {
        if (a > b) return a;
        else return b;
    }
}