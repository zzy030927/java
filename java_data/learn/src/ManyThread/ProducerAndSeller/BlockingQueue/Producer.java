package ManyThread.ProducerAndSeller.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer extends Thread{

    ArrayBlockingQueue queue;

    public Producer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // ���ϵذ������ŵ�����������
        while(true){
            try {
                queue.put("����");    // put ��������������
                System.out.println("��ʦ����һ������"); // sout �������������
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
