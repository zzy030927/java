package cn.itcast.chapter10.example04;
/**
 * ��Ʊ����ͨ���̳�Thread��ķ�ʽ��ʵ�ֶ��̵߳Ĵ���
 */
public class Example04 {
	public static void main(String[] args) {
		new TicketWindow().start(); // ������һ���̶߳���TicketWindow������
		new TicketWindow().start(); // �����ڶ����̶߳���TicketWindow������
		new TicketWindow().start(); // �����������̶߳���TicketWindow������
		new TicketWindow().start(); // �������ĸ��̶߳���TicketWindow������
	}
}
class TicketWindow extends Thread {
	private int tickets = 100;
	public void run() {
		while (true) { // ͨ����ѭ������ӡ���
			if (tickets > 0) {
				Thread th = Thread.currentThread(); // ��ȡ��ǰ�߳�
				String th_name = th.getName(); // ��ȡ��ǰ�̵߳�����
				System.out.println(th_name + " ���ڷ��۵� " + tickets-- + " ��Ʊ ");
			}
		}
	}
}