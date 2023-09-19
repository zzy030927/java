package CollectionDemo;
import java.util.Arrays;
import java.util.Random;

// Arrays 类的使用,在 java.util 包上面
// Arrays 数组不可变，基于此 java 封装了 ArrayList,它是可变数组

// 排数方法，查找方法
public class arrays
{
    public static void main(String[] args)
    {
        testArraysSort();
    }

    public static int[] generatorRandomArray(int length)    // 产生一个随机数组
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
        Arrays.sort(array);      // 此方法为 静态方法，可以直接调用
        System.out.print(Arrays.toString(array)); // Arrays 里面的静态方法 toString() ，把一个数组 转换为一个列表

        // Arrays.binarySearch() 静态函数，第一个参数为 升序的数组 ，第二个参数为 int,double,..... 类型的参数，
        // 如果传入的值 在 数组中找到，那么返回这个 数的索引， 否则返回 改值 在 插入数组中的位置 + 1 的 负数。
        int RandomNumber = generatorRandomNumber();
        System.out.println("\n" + RandomNumber);
        System.out.println(Arrays.binarySearch(array, RandomNumber));
    }
}
