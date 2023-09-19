package cn.itcast.chapter10.example07;
/**
 * sleep(long millis) �����ڳ����е�ʹ�� 
 */
public class Example07 {
	public static void main(String[] args) throws Exception {
		//����һ���߳�
		new Thread(new Task()).start();		
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				Thread.sleep(2000); //��ǰmain���߳� ����2��
			} else {
				Thread.sleep(500); 
			}
			System.out.println("main���߳����������" + i);
		}
	}
}
//�����̵߳�������
class Task implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try{
				if (i == 3) {
					Thread.sleep(2000);//��ǰ�߳�����2��
				} else {
					Thread.sleep(500);
				}
				System.out.println("�߳�һ���������" + i);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}