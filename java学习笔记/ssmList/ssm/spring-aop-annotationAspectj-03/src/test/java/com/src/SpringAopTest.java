package com.src;

import com.src.config.JavaConfig;
import com.src.service.Cal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
public class SpringAopTest {

    // 如果需要代理的类有接口，那么会选择jdk代理，生成一个接口的代理类对象。
    // 如果没有接口，那么会用cglib代理，继承这个类。
    @Autowired
    private Cal cal;

    @Test
    public void test() {
        cal.add(1, 1);
    }
}
