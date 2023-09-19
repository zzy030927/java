package DesignRule.DifatRule;

public class Test {
    public static void main(String[] args) {
        Star star = new Star("²ÌĞìÀ¤");
        Fans fans = new Fans("Ğ¡ºÚ×Ó");
        Company company = new Company("Ì©¿áÀ±¹«Ë¾");
        Agent agent = new Agent();

        agent.setStar(star);
        agent.setFans(fans);
        agent.setCompany(company);

        agent.meeting();
        agent.business();
    }
}
