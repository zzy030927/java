package cn.itcast.chapter10.example05;
/**
 * ��Ʊ����ͨ��ʵ�� Runnable�ӿڵķ�ʽ���������߳�
 */
public class Example05 {
	public static void main(String[] args) {
		TicketWindow task = new TicketWindow();//�����̵߳����������
		new Thread(task, "����1").start();//�����̲߳�����Ϊ����1�� �����߳�
		new Thread(task, "����2").start();//�����̲߳�����Ϊ����2�� �����߳�
		new Thread(task, "����3").start();//�����̲߳�����Ϊ����3�� �����߳�
		new Thread(task, "����4").start();//�����̲߳�����Ϊ����4�� �����߳�
	}
}

//�̵߳�������
class TicketWindow implements Runnable {
	private int tickets = 100;
	@Override
	public void run() {
		while(true){
			if (tickets > 0) {
				Thread th = Thread.currentThread();//��ȡ��ǰ����run�������߳�
				String th_name = th.getName();//�õ��̵߳�����
				System.out.println(th_name + "���ڷ��۵�" + tickets-- + "��Ʊ");
			}
		}
	}
}