package student.learn_java;
import java.util.Random;    // ������� API

public class random
{
    public static void main(String args[])
    {
        Random RandomRange = new Random();
        for(int i = 0; i < 3; i++)
        {
            int number = RandomRange.nextInt(10);   // ����һ�� 0 - 9 �������
            System.out.println(number);
        }
    }
}
