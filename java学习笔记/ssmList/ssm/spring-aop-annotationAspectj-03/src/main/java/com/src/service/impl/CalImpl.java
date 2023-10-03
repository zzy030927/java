package com.src.service.impl;

import com.src.service.Cal;
import org.springframework.stereotype.Service;

@Service
public class CalImpl implements Cal {

    @Override
    public int add(int i, int j) {
        System.out.println("执行add()方法");
        int res = i + j;
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res = i * j;
        return res;
    }

    @Override
    public int div(int i, int j) {
        int res = i / j;
        return res;
    }
}

