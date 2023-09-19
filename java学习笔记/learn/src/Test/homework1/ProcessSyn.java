package Test.homework1;

public class ProcessSyn {
    public static void main(String[] args) {

        MyThread PA = new MyThread();                   // 线程 PA
        MyThread PB = new MyThread();                   // 线程 PB
        PA.setName("PA");
        PB.setName("PB");

        PA.start();
        PB.start();
    }
}
