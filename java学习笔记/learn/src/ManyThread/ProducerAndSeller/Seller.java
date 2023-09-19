package ManyThread.ProducerAndSeller;

// ������
public class Seller extends Thread {
    @Override
    public void run() {
        while(true){
            synchronized (Platform.lock){
                if(Platform.count == 0){
                    break;
                }else {
                    // ���ж� Platform��ƽ̨�ϣ� �Ƿ���ʳ��
                    if(Platform.foodFlag == 0) {
                        // ƽ̨��û��ʳ���ȥ�� ���� Producer ����ʳ��
                        try {
                            Platform.lock.wait();   // �������� wait() ������ �õ�ǰ�̺߳������а󶨣��õ�ǰ�߳�ȥ�ȴ���
                                                    // �����̱߳� Producer ��ռ
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("�ڳԵ�" + Platform.count + "��ʳ��");
                        Platform.count--;   // ʳ������ -1
                        // ����֮�󣬻��� Produce ��������ʳ��
                        Platform.lock.notifyAll(); // ֮���Ե�ǰ�߳�Ҫ�������а󶨣�����˵���Ѹ��߳�ʱ֪�����ѵ��������̡߳�
                                                   // ���ֱ�ӵ��� notify()������ �ỽ�����е��̡߳�
                                                   // �����ǻ���������ȥ��ʳ��

                        Platform.foodFlag = 0;     // ����ƽ̨��û��ʳ��
                    }
                }
            }
        }
    }
}
