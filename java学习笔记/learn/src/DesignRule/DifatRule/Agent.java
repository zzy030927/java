package DesignRule.DifatRule;

// ������
public class Agent {
    private Star star;
    private Company company;
    private Fans fans;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    // ���˿����ķ���
    public void meeting(){
        System.out.println(star.getName() + "��" + fans.getName() + "����");
    }

    // ��ý�幫˾Ǣ̸�ķ���
    public void business(){
        System.out.println(star.getName() + "��" + company.getName() + "Ǣ̸");
    }

}
