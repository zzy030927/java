package Test.homework3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Lru {
    public static final int MEMORY_SIZE = 5;
    public static int add = 1;
    public static void main(String[] args) {
        System.out.println("LUR算法执行: ");
        int lackCount = 1;       // 缺页次数
        int replaceCount = 0;    // 置换次数
        LinkedList<Integer> memory = new LinkedList<>();    // 初始化内存表
        ArrayList<Integer> pageList = randomPage();         // 随机页面
        int[] oldPageList = new int[]{-2, -2, -2, -2, -2};
        oldPageList[0] = pageList.get(0);
        printList(pageList);
        memory.addLast(pageList.get(0));
        for (int i = 0; i < pageList.size(); i++) {
            if(memory.size() < MEMORY_SIZE) {                                // 内存表内页面未满
                if(!findPage(pageList.get(i), memory)) {                     // 如果内存表内没有该页，发生缺页中断
                    memory.addLast(pageList.get(i));
                    findOldPage(oldPageList, pageList.get(i), true);
                    lackCount++;
                } else {
                    findOldPage(oldPageList, pageList.get(i), true);    // 否则调换出最新的页面放入栈顶，其他页面前移
                }
            } else {                                                         // 内存表内内存已满
                if(!findPage(pageList.get(i), memory)) {                     // 没有找到该页，发生缺页中断
                    int oldPage = findOldPage(oldPageList, pageList.get(i), false);     // 找出要置换的新的页面
                    int index = getIndex(oldPage, memory);                   // 找出该页的页面
                    memory.set(index, pageList.get(i));                      // 置换
                    replaceCount++;
                    lackCount++;
                } else {
                    findOldPage(oldPageList, pageList.get(i), false);   // 否则调换出新的页面放入栈顶，其他页面前移
                }
            }
            printMemory(memory);
        }
        System.out.println("缺页次数为: " + lackCount + "\n置换次数为: " + replaceCount);
    }

    public static int getIndex(int oldPage, LinkedList<Integer> memory) {
        for (int i = 0; i < memory.size(); i++) {
            if(oldPage == memory.get(i))
                return i;
        }
        return -1;
    }

    public static int findOldPage(int[] oldPageList, int currPage, boolean flag) {
        int oldPage = -1;
        int pageIndex;
        if(!isFull(oldPageList)) {
            if((pageIndex = isAdded(oldPageList, currPage)) == -1)
                oldPageList[add++] = currPage;
            else if(add != 1) {
                changePage(oldPageList, currPage, pageIndex, add);
            }
        } else {
            oldPage = oldPageList[0];
            if((pageIndex = isAdded(oldPageList, currPage)) != -1) {
                changePage(oldPageList, currPage, pageIndex, MEMORY_SIZE);
            } else {
                for (int i = 0; i < MEMORY_SIZE - 1; i++) {
                    oldPageList[i] = oldPageList[i + 1];
                }
            }
            oldPageList[MEMORY_SIZE - 1] = currPage;
        }
        return flag ? oldPageList[0] : oldPage;
    }

    public static void changePage(int[] oldPageList, int currPage, int pageIndex, int num) {
        int tag = currPage;
        for (int i = pageIndex; i < num - 1; i++) {
            oldPageList[i] = oldPageList[i + 1];
        }
        oldPageList[num - 1] = tag;
    }

    private static boolean isFull(int[] oldPageList) {
        for (int i = 0; i < oldPageList.length; i++) {
            if(oldPageList[i] == -2)
                return false;
        }
        return true;
    }

    public static int isAdded(int[] oldPageList, int page) {
        for (int i = 0; i < oldPageList.length; i++) {
            if(page == oldPageList[i]) {
                return i;
            }
        }
        return -1;
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
