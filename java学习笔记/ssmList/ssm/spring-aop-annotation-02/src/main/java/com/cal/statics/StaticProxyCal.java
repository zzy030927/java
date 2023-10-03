package com.cal.statics;

import com.cal.Cal;
import org.springframework.stereotype.Controller;

// 静态代理
@Controller
public class StaticProxyCal implements Cal {

    private final Cal cal;

    public StaticProxyCal(Cal cal) {
        this.cal = cal;
    }

    @Override
    public int add(int i, int j) {
        // 非核心业务代码
        System.out.println("i = " + i + ", j = " + j);
        // 核心业务代码
        int res = cal.add(1, 1);
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
