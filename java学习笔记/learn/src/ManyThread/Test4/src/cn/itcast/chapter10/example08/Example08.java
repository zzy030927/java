package cn.itcast.chapter10.example08;
/**
 * �߳��ò���yield()������ʹ��
 */
// ����YieldThread��̳�Thread��
class YieldThread extends Thread {
     // ����һ���вεĹ��췽��
	public YieldThread(String name) { 
		super(name); // ���ø���Ĺ��췽��
	}
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + "---" + i);
			if (i == 3) {
				System.out.print("�߳��ò�:");
				Thread.yield(); // �߳����е��ˣ������ò�
			}
		}
	}
}
public class Example08 {
	public static void main(String[] args) {
         // ���������߳�
		Thread t1 = new YieldThread("�߳�A");
		Thread t2 = new YieldThread("�߳�B");
         // ���������߳�
		t1.start();
		t2.start();
	}
}