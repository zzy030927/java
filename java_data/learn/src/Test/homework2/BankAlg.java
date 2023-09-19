package Test.homework2;

import java.util.ArrayList;
import java.util.Random;

public class BankAlg {
    static int[] available = new int[]{3, 3, 2};
    static int[][] need = new int[5][3];
    static int[][] max = new int[][]{{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
    static int[][] allocation = new int[][]{{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
    public static void main(String[] args) {
        // 三类资源 A B C
        boolean flag = true;
        ArrayList<Integer> currList;
        while(flag) {
            calNeed();
            if(isEmpty()) {
                System.out.println("分配结束");
                System.out.println("资源总数为: ");
                for (int i = 0; i < available.length; i++) {
                    System.out.print(available[i] + " ");
                }
                flag = false;
            }
            else {
                printTable();
                int currProcess = getRandomProcess();
                System.out.println("当前的线程为: " + currProcess);
                currList = getRandomCurrResourceNum(currProcess);
                if(currList.size() != 0) {
                    System.out.print("想要获得的资源个数为: ");
                    for (int i = 0; i < currList.size(); i++) {
                        System.out.print(currList.get(i) + " ");
                    }
                    System.out.println();
                    if (!whetherAllocation(currProcess, currList)) {
                        System.out.println("资源分配会导致系统进入不安全状态，不进行分配资源");
                    } else {
                        System.out.println("可进行资源分配");
                        calAllocation(currProcess, currList);
                        calNeed();
                        calAvailable(currList);
                        if (isSatisfy(currProcess)) {
                            System.out.println("进程" + currProcess + "已完成任务，释放资源");
                            releaseRes(currProcess);
                            max = popProcess(currProcess, max);
                            allocation = popProcess(currProcess, allocation);
                            need = popProcess(currProcess, need);
                        }
                    }
                }
                System.out.println("===============");
            }
        }
    }

    private static void calAvailable(ArrayList<Integer> currList) {     // 计算 available 矩阵
        for (int i = 0; i < available.length; i++) {
            available[i] -= currList.get(i);
        }
    }

    static void printTable() {      // 打印各个矩阵
        System.out.println("Max\t\tAllocation\t\tNeed\tAvailable");
        for (int i = 0; i < max.length; i++) {
            for (int j = 0; j < max[i].length; j++) {
                System.out.print(max[i][j] + " ");
            }
            System.out.print("\t");
            for (int j = 0; j < allocation[i].length; j++) {
                System.out.print(allocation[i][j] + " ");
            }
            System.out.print("\t\t\t");
            for (int j = 0; j < need[i].length; j++) {
                System.out.print(need[i][j] + " ");
            }
            System.out.print("\t");
            if(i == 0)
                for (int j = 0; j < available.length; j++) {
                    System.out.print(available[j] + " ");
                }
            System.out.println();
        }
    }

    static int[][] popProcess(int currProcess, int[][] currPop) {   // 删除线程
        int[] copy;
        for (int i = currProcess; i < currPop.length - 1; i++) {
            copy = currPop[i + 1].clone();
            currPop[i] = copy.clone();
        }
        int[][] newList = new int[currPop.length - 1][3];
        for (int i = 0; i < newList.length; i++) {
            for (int j = 0; j < newList[i].length; j++) {
                newList[i][j] = currPop[i][j];
            }
        }
        return newList;
    }

    static void releaseRes(int currProcess) {   // 释放线程资源
        for (int i = 0; i < allocation[currProcess].length; i++) {
            available[i] += allocation[currProcess][i];
        }
    }

    static boolean isSatisfy(int currProcess) {     // 判断当前线程的 need 矩阵是否都为 0，都为 0，那么说明该线程可释放资源
        boolean flag = true;
        for (int i = 0; i < need[currProcess].length; i++) {
            if (need[currProcess][i] != 0)
                flag = false;
        }
        return flag;
    }

    static void calAllocation(int currProcess, ArrayList<Integer> currList) {   // 计算 allocation 矩阵
        for (int i = 0; i < currList.size(); i++) {
            allocation[currProcess][i] += currList.get(i);
        }
    }

    static boolean isEmpty() {      // 判断 need 矩阵是否为空，为空结束程序运行
        for (int i = 0; i < need.length; i++) {
            for (int j = 0; j < need[i].length; j++) {
                if(need[i][j] != 0) return false;
            }
        }
        return true;
    }
    static void calNeed() {         // 计算 need 矩阵
        for (int i = 0; i < max.length; i++) {
            for (int j = 0; j < max[i].length; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
    }

    static int getRandomProcess() {     // 随即线程
        Random random = new Random();
        int index = random.nextInt(allocation.length);
        return index;
    }

    static ArrayList<Integer> getRandomCurrResourceNum(int currProcess) {   // 随机资源个数
        ArrayList<Integer> resList = new ArrayList<>();
        boolean flag = true;
        Random random = new Random();
        if(check(currProcess)){
            while (flag) {
                for (int i = 0; i < need[currProcess].length; i++) {
                    int number = random.nextInt(need[currProcess][i] + 1 < available[i] + 1 ? need[currProcess][i] + 1 : available[i] + 1);
                    resList.add(number);
                    if (number != 0) flag = false;
                }
                if (flag) resList.clear();
            }
        } else {
            System.out.println("资源不足，无法分配");
        }
        return resList;
    }

    static boolean check(int currProcess) {
        for (int i = 0; i < available.length; i++) {
            if(need[currProcess][i] != 0 && available[i] != 0)  // 特殊情况： 线程 1 需要资源个数 0 0 1，现在空闲的资源 1 1 0，那么资源不足，无法分配
                return true;
        }
        return false;
    }

    static boolean whetherAllocation(int currProcess, ArrayList<Integer> currList) {    // 判断当前线程是否可分配资源
        int[] surplusAvailable = available.clone();
        int[][] cloneNeed = need.clone();
        boolean isNull = true;
        for (int i = 0; i < available.length; i++) {
            if(currList.get(i) > available[i] && currList.get(i) > need[currProcess][i] )
                return false;
            else {
                surplusAvailable[i] -= currList.get(i);
                cloneNeed[currProcess][i] -= currList.get(i);
                if(surplusAvailable[i] != 0 || cloneNeed[currProcess][i] != 0) isNull = false;   // 判断随机到的资源是否全是 0
            }
        }
        if (isNull || surplusWhetherAllocation(surplusAvailable, cloneNeed))
            return true;
        return false;
    }

    static boolean surplusWhetherAllocation(int[] surplusAvailable, int[][] need) {     // 判断是否有安全序列
        int[][] copyNeed = need.clone();
        int[][] copyAllocation = allocation.clone();
        while (copyNeed.length != 0) {
            int satisfyProcess = findSatisfyProcess(surplusAvailable, copyNeed);
            if(satisfyProcess != -1) {
                for (int i = 0; i < surplusAvailable.length; i++) {
                    surplusAvailable[i] += copyAllocation[satisfyProcess][i];
                }
                copyNeed = popProcess(satisfyProcess, copyNeed);
                copyAllocation = popProcess(satisfyProcess, copyAllocation);
            } else {
                return false;
            }
        }
        return true;
    }
    static int findSatisfyProcess(int[] surplusAvailable, int[][] copyNeed) {       // 获取满足当前的空闲资源可分配的线程
        int flag = -1;
        boolean tag = false;
        for (int i = 0; i < copyNeed.length; i++) {
            tag = false;
            for (int j = 0; j < copyNeed[i].length; j++) {
                if(surplusAvailable[j] < copyNeed[i][j]) {
                    tag = true;
                    break;
                }
            }
            if(!tag) {
                flag = i;
                break;
            }
        }
        return flag;
    }
}

