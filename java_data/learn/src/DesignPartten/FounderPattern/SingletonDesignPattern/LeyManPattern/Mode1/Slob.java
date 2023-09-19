package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode1;

// �������ģʽ - ����ʽ - ʵ�ַ�ʽһ���÷�ʽ�̲߳���ȫ��
public class Slob {
    // ˽�й��췽��
    private Slob() {}

    // �������ྲ̬����
    private static Slob instance = null;

    // �����ṩ���ʷ�ʽ
    public static synchronized Slob getInstance(){
        if(instance == null)    // ��� instance ��û�д�������ô�����ö��󣬷���Ͳ�����
            // �˴��߳��ǲ���ȫ�ģ���Ϊ ����˴�Ϊ���̣߳�
            // �߳�һ���̶߳�ͬʱ���ø÷������߳�һ����÷���ʱ�����жϺ�ʱ��Ƭ������еȴ�
            // �̶߳���ȡcpu����Ȩ��ͬʱ�߳�һ��û�д���������ô�̶߳�Ҳ����÷��������жϵȴ���������
            // �̶߳�ʱ��Ƭ���꣬�߳�һ��������
            // ��Ϊ�̶߳��Ѿ��ж���ϣ������̶߳�Ҳ������һ������
            instance = new Slob();
        return instance;
    }
}
