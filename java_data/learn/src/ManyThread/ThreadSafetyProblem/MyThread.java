package ManyThread.ThreadSafetyProblem;

public class MyThread extends Thread{

    static int ticket = 0;
    static Object obj = new Object();

    @Override
    public synchronized void run() {    // 修饰符后面加一个 synchronized 关键字，那么这个方法就变成了一个同步方法。
        while(true){
            synchronized (MyThread.class){ // synchronized () 同步代码块，里面的参数为 锁，锁是任意的静态的变量
                                            // 锁对象一定要是唯一的，即如果是一个变量那么就加 static 关键字
                                            // 即括号内的参数填 obj 也是可以的,
                                            // 同样，当前文件的字节码文件也是唯一的
                if(ticket < 100){
                    ticket++;
                    System.out.println(getName() + "正在第卖" + ticket + "张票!");
                }
                else {
                    break;
                }
            }
        }
    }
}
