package Test.homework3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
    设某作业包含 0-9 共 10 个页面，并假设系统安排给该作业 5 个内存块。
    随机设一个页面走向序列，然后分别用 FIFO 算法和 LRU 算法实现页面转换过程，统计发生缺页次数、页面置换次数。
 */
public class Fifo {
    public static final int MEMORY_SIZE = 5;
    public static void main(String[] args) {
        System.out.println("FIFO算法执行: ");
        int lackCount = 1;       // 缺页次数
        int replaceCount = 0;    // 置换次数
        LinkedList<Integer> memory = new LinkedList<>();
        ArrayList<Integer> pageList = randomPage();
        printList(pageList);
        memory.addLast(pageList.get(0));
        for (int i = 0; i < pageList.size(); i++) {
            if(memory.size() < MEMORY_SIZE) {
                if(!findPage(pageList.get(i), memory)) {
                    memory.addLast(pageList.get(i));
                    lackCount++;
                }
            } else {
                if(!findPage(pageList.get(i), memory)) {
                    memory.set(replaceCount % MEMORY_SIZE, pageList.get(i));
                    replaceCount++;
                    lackCount++;
                }
            }
            printMemory(memory);
        }
        System.out.println("缺页次数为: " + lackCount + "\n置换次数为: " + replaceCount);
    }

    public static void printList(ArrayList<Integer> pageList) {
        System.out.println("随机到的内存页为: ");
        for (int i = 0; i < pageList.size(); i++) {
            System.out.print(pageList.get(i) + " ");
        }
        System.out.println();
    }

    public static void printMemory(LinkedList<Integer> memory) {
        System.out.print("当前内存为: ");
        for (int i = 0; i < memory.size(); i++) {
            System.out.print(memory.get(i) + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> randomPage() {
        Random random = new Random();
        ArrayList<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pageList.add(random.nextInt(10));
        }
        return pageList;
    }

    public static boolean findPage(Integer page, LinkedList<Integer> memory) {
        for (int i = 0; i < memory.size(); i++) {
            if(page == memory.get(i))
                return true;
        }
        return false;
    }
}
