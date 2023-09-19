package ManyThread.Test4.src.cn.itcast.chapter10.task01;
/**
 * ´¢»§Àà
 */
public class Customer1 implements Runnable{
	private Bank b = new Bank();
	public void run() {
		for(int i=0; i<3; i++) {
				b.add(100);
		}
	}
}