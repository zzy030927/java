package student.learn_java;
import java.util.Random;    // 随机数的 API

public class random
{
    public static void main(String args[])
    {
        Random RandomRange = new Random();
        for(int i = 0; i < 3; i++)
        {
            int number = RandomRange.nextInt(10);   // 产生一个 0 - 9 的随机数
            System.out.println(number);
        }
    }
}
