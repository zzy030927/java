package cn.itcast.chapter10.example06;
/**
 * ��ͬ���ȼ��������߳��ڳ������������
 */
public class Example06 {
	public static void main(String[] args) {
		//���������߳�
		Thread minPriority = new Thread(new Task(), "���ȼ��ϵ͵��߳� ");
		Thread maxPriority = new Thread(new Task(), "���ȼ��ϸߵ��߳� ");
		minPriority.setPriority(Thread.MIN_PRIORITY); //�����̵߳����ȼ�Ϊ1  
		maxPriority.setPriority(Thread.MAX_PRIORITY); //�����̵߳����ȼ�Ϊ10
		//���������߳�
		minPriority.start();
		maxPriority.start();
	}
}

//����һ���̵߳�������
class Task implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "�������" + i);
		}
	}
}