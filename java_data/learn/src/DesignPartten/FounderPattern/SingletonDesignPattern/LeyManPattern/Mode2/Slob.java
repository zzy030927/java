package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode2;

// �������ģʽ - ����ʽ - ʵ�ַ�ʽ����˫�ؼ����
public class Slob {
    private Slob() {}

    // �������͵ı���
    private static volatile Slob instance = null;

    // �����ṩ�����ķ��ʷ�ʽ
    public static  Slob getInstance(){
        // ��һ���жϣ� ��� instance ��ֵ��Ϊ null, ��ô����Ҫ��ռ����ֱ�ӷ��ض���
        if(instance == null){
            // ͬ������飬����Ϊ �����󣬼���ǰ����ֽ������
            synchronized (Slob.class){
                // ���ⱻ������������ռ�����������ж�һ��
                if(instance == null){
                    instance = new Slob();
                }
            }
        }
        return instance;
    }
}
