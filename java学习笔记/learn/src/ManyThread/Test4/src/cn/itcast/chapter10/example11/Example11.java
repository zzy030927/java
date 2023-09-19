package cn.itcast.chapter10.example11;

/**
 * ͬ�������
 */
public class Example11 {
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
	Object lock = new Object();// ��������һ����������ͬ����������

	@Override
	public void run() {
		while (true) {
			synchronized (lock) { // ����ͬ�������
				try {
					Thread.sleep(10);// �߳�����10����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tickets > 0) {
					System.out.println(Thread.currentThread().getName()
							+ "---������Ʊ" + tickets--);
				} else {
					break;
				}
			}
		}
	}
}