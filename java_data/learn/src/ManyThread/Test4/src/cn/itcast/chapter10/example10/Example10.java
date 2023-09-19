package cn.itcast.chapter10.example10;

/**
 * ��Ʊ����ͨ��ʵ�� Runnable�ӿڵķ�ʽ���������߳�
 */
public class Example10 {
	public static void main(String[] args) {
		TicketWindow task = new TicketWindow();// �����̵߳����������
		new Thread(task, "����1").start();// �����̲߳�����Ϊ����1�� �����߳�
		new Thread(task, "����2").start();// �����̲߳�����Ϊ����2�� �����߳�
		new Thread(task, "����3").start();// �����̲߳�����Ϊ����3�� �����߳�
		new Thread(task, "����4").start();// �����̲߳�����Ϊ����4�� �����߳�
	}
}
// �̵߳�������
class TicketWindow implements Runnable {
	private int tickets = 10; // 10��Ʊ
	@Override
	public void run() {
		while (tickets > 0) {
			try {
				Thread.sleep(10);// �߳�����10����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "---������Ʊ"
					+ tickets--);
		}
	}
}