package DesignRule.DifatRule;

public class Test {
    public static void main(String[] args) {
        Star star = new Star("������");
        Fans fans = new Fans("С����");
        Company company = new Company("̩������˾");
        Agent agent = new Agent();

        agent.setStar(star);
        agent.setFans(fans);
        agent.setCompany(company);

        agent.meeting();
        agent.business();
    }
}
