package Test.homework1;

public class ProcessSyn {
    public static void main(String[] args) {

        MyThread PA = new MyThread();                   // �߳� PA
        MyThread PB = new MyThread();                   // �߳� PB
        PA.setName("PA");
        PB.setName("PB");

        PA.start();
        PB.start();
    }
}
