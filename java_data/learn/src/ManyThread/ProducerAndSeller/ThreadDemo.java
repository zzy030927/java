package ManyThread.ProducerAndSeller;

public class ThreadDemo {
    public static void main(String[] args) {
        // ������������ͺ������ߣ��ȴ����ѻ��ƣ��Ĵ���
        // ʵ���̵߳����������Ч��


        // �����̶߳���
        Producer producer = new Producer();
        Seller seller = new Seller();

        producer.setName("������");
        seller.setName("������");

        producer.start();
        seller.start();
    }
}
