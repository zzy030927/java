package com.cal;

import com.cal.dynamic.JdkProxyCal;
public class Test {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        // jdk代理
        JdkProxyCal factory = new JdkProxyCal(cal);
        // getProxy()获取代理对象，类型为Cal的实现类
        Cal proxy = (Cal) factory.getProxy();
        proxy.add(1, 1);
    }
}