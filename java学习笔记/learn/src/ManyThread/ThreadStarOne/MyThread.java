package ManyThread.ThreadStarOne;

// 1. �̳� Thread ��
public class MyThread extends Thread{

    @Override
    public void run(){
        // ��д��д�Ĵ���
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() +"����" + (i+1));
            Thread.yield(); // ��ǰ�ȵ����������̣߳�����CPU����Ȩ
        }
    }
}
