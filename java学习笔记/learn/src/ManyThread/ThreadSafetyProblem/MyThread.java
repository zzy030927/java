package ManyThread.ThreadSafetyProblem;

public class MyThread extends Thread{

    static int ticket = 0;
    static Object obj = new Object();

    @Override
    public synchronized void run() {    // ���η������һ�� synchronized �ؼ��֣���ô��������ͱ����һ��ͬ��������
        while(true){
            synchronized (MyThread.class){ // synchronized () ͬ������飬����Ĳ���Ϊ ������������ľ�̬�ı���
                                            // ������һ��Ҫ��Ψһ�ģ��������һ��������ô�ͼ� static �ؼ���
                                            // �������ڵĲ����� obj Ҳ�ǿ��Ե�,
                                            // ͬ������ǰ�ļ����ֽ����ļ�Ҳ��Ψһ��
                if(ticket < 100){
                    ticket++;
                    System.out.println(getName() + "���ڵ���" + ticket + "��Ʊ!");
                }
                else {
                    break;
                }
            }
        }
    }
}
