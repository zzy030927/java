package ManyThread.Test;

public class MyThread extends Thread {
    static int a = 1;
    static boolean flag = false;
    @Override
    public void run() {
        while (true) {
            while(a <= 100) {
                synchronized (MyThread.class) {
                    if (a % 2 == 0)
                        System.out.println(getName() + "»ñÈ¡ÁË" + a);
                    if (a > 100) {
                        flag = true;
                        a++;
                        break;
                    }
                    a++;
                }
            }
            if(flag) break;
        }
    }
}
