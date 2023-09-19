package ManyThread.Test4.src.cn.itcast.chapter10.task01;

/**
 * ²âÊÔÀà
 */
public class SaveMoneyTest {
	public static void main(String[] args) {
		Customer1 c = new Customer1();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}