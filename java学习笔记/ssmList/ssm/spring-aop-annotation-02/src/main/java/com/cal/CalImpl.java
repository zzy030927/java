package com.cal;

import org.springframework.stereotype.Service;

@Service("cal")
public class CalImpl implements Cal {

    @Override
    public int add(int i, int j) {
        int res = i + j;
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
