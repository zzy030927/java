package CollectionDemo;
import java.util.Arrays;
import java.util.Random;

// Arrays ���ʹ��,�� java.util ������
// Arrays ���鲻�ɱ䣬���ڴ� java ��װ�� ArrayList,���ǿɱ�����

// �������������ҷ���
public class arrays
{
    public static void main(String[] args)
    {
        testArraysSort();
    }

    public static int[] generatorRandomArray(int length)    // ����һ���������
    {
        int[] arrays = new int[length];
        Random ran = new Random();
        for(int i = 0; i < length; i++)
        {
            arrays[i] = ran.nextInt(10);
        }
        return arrays;
    }

    public static int generatorRandomNumber()
    {
        Random ran = new Random();
        int number = ran.nextInt(10);
        return number;
    }

    public static void testArraysSort()
    {
        int length = 10;
        int[] array;
        array = generatorRandomArray(length);
        Arrays.sort(array);      // �˷���Ϊ ��̬����������ֱ�ӵ���
        System.out.print(Arrays.toString(array)); // Arrays ����ľ�̬���� toString() ����һ������ ת��Ϊһ���б�

        // Arrays.binarySearch() ��̬��������һ������Ϊ ��������� ���ڶ�������Ϊ int,double,..... ���͵Ĳ�����
        // ��������ֵ �� �������ҵ�����ô������� ���������� ���򷵻� ��ֵ �� ���������е�λ�� + 1 �� ������
        int RandomNumber = generatorRandomNumber();
        System.out.println("\n" + RandomNumber);
        System.out.println(Arrays.binarySearch(array, RandomNumber));
    }
}
