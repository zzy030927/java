package ExceptionDemo;

// ����ʹ�õķ���
// getMessage() �����쳣����ϸ��Ϣ�ַ���
// toString() ���ؿ��׳��ļ������
// printStackTrace() ���쳣�Ĵ�����Ϣ��ӡ������̨��
public class UsuallyUserMethod {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        try {
            System.out.println(nums[6]);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName()); // ����
            System.out.println(e);
            e.printStackTrace();
        }
        System.err.println("--------------123------------");    // �����ݱ�Ϊ������Ϣ���д�ӡ
    }
}
