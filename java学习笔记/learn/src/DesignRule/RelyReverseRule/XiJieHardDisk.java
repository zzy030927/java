package DesignRule.RelyReverseRule;

// ϣ��Ӳ��
public class XiJieHardDisk implements HardDisk{
    // �洢���ݵķ���
    public void save(String data){
        System.out.println("ʹ��ϣ��Ӳ�̴洢����Ϊ: " + data);
    }

    public String get(){
        System.out.println("ʹ��ϣ��Ӳ��ȡ����");
        return "����";
    }
}
