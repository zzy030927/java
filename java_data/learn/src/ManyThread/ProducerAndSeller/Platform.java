package ManyThread.ProducerAndSeller;

// ���������ߺ������ߵĽ���ִ��
public class Platform { // platform �� ƽ̨
    public static int foodFlag = 0;  // 1 ��ʾ��ʳ�0 ��ʾû��ʳ��

    // ʳ���ܸ���
    public static int count = 10;

    // ������
    public static Object lock = new Object();
}
