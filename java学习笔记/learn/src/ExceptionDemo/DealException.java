package ExceptionDemo;

// �����쳣
// JVM Ĭ�ϰ��쳣���ơ��쳣��Ϣ���쳣λ�õ���Ϣ����ڿ���̨��ͬʱֹͣ��������
// �Լ������쳣 try/catch��׽,���Լ����ó���ִ�У�����ֹͣ
public class DealException {
    public static void main(String[] args) {
        try {
            System.out.println("����ȳ����������");
            System.out.println(2/0);    // �쳣���ֺ�������벻������
            System.out.println("���ζ����");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("��ζ����");
    }
}
