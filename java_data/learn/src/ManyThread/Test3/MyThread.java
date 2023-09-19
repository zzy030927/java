package ManyThread.Test3;

import java.util.ArrayList;
import java.util.Random;

public class MyThread extends Thread {

    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {   // 创建对象时把集合传进来
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            try {
                sleep(100);
                synchronized (MyThread.class) {
                    if (list.size() == 0) {
                        System.out.println(getName() + boxList);
                        break;
                    } else {
                        Random random = new Random();
                        int index = random.nextInt(list.size());
                        if (index != 0) index -= 1;
                        Integer prize = list.remove(index);
                        if ("线程1".equals(getName())) {
                            boxList.add(prize);
                        } else {
                            boxList.add(prize);
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
