package ManyThread.ProducerAndSeller.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

// �� �������з�ʽʵ��������������������
public class ThreadDemo {
    public static void main(String[] args) {
        // �����ߺ������߱������һ������������

        // ��������
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(1);    // ������ʽ���������У�1 Ϊ����

        // �����߳�
        Producer producer = new Producer(arrayBlockingQueue);
        Seller seller = new Seller(arrayBlockingQueue);

        producer.start();
        seller.start();
    }
}
