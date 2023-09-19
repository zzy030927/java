package ManyThread.ProducerAndSeller;

// ������
public class Producer extends Thread {
    @Override
    public void run() {
        while(true){
            synchronized (Platform.lock){
                if(Platform.count == 0){
                    break;
                }else {
                    if (Platform.foodFlag == 1) {    // �ж�ƽ̨���Ƿ���ʳ��
                        try {
                            Platform.lock.wait();   // ��ʳ��͵ȴ������߳�ʳ��
                                                    // �̱߳� Seller ��ռ
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("��ʦ����һ������");
                        Platform.foodFlag = 1;
                        // ���ѵȴ��������߳�ʳ��
                        Platform.lock.notifyAll();
                    }
                }
            }
        }
    }
}
