package cn.itcast.chapter10.example02;
/**
 * ͨ���̳�Thread��ķ�ʽ��ʵ�ֶ��߳�
 */
public class Example02 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread(); // �����߳�MyThread���̶߳���
		myThread.start(); // �����߳�
		while (true) { // ͨ����ѭ������ӡ���
			System.out.println("main()����������");
		}
	}
}
class MyThread extends Thread {
	public void run() {
		while (true) { // ͨ����ѭ������ӡ���
			System.out.println("MyThread���run()����������");
		}
	}
}
