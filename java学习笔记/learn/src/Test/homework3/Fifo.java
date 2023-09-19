package Test.homework3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
    ��ĳ��ҵ���� 0-9 �� 10 ��ҳ�棬������ϵͳ���Ÿ�����ҵ 5 ���ڴ�顣
    �����һ��ҳ���������У�Ȼ��ֱ��� FIFO �㷨�� LRU �㷨ʵ��ҳ��ת�����̣�ͳ�Ʒ���ȱҳ������ҳ���û�������
 */
public class Fifo {
    public static final int MEMORY_SIZE = 5;
    public static void main(String[] args) {
        System.out.println("FIFO�㷨ִ��: ");
        int lackCount = 1;       // ȱҳ����
        int replaceCount = 0;    // �û�����
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
        System.out.println("ȱҳ����Ϊ: " + lackCount + "\n�û�����Ϊ: " + replaceCount);
    }

    public static void printList(ArrayList<Integer> pageList) {
        System.out.println("��������ڴ�ҳΪ: ");
        for (int i = 0; i < pageList.size(); i++) {
            System.out.print(pageList.get(i) + " ");
        }
        System.out.println();
    }

    public static void printMemory(LinkedList<Integer> memory) {
        System.out.print("��ǰ�ڴ�Ϊ: ");
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
