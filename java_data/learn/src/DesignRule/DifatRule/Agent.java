package DesignRule.DifatRule;

// 代理人
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

    // 与粉丝见面的方法
    public void meeting(){
        System.out.println(star.getName() + "和" + fans.getName() + "见面");
    }

    // 与媒体公司洽谈的方法
    public void business(){
        System.out.println(star.getName() + "和" + company.getName() + "洽谈");
    }

}
