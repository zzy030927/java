package test;

import components.A;
import config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

// locations指定配置文件 , value指定配置类
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIocTest {

    @Autowired
    private A a;

    @Test
    public void test() {
        // ioc容器
        // 读取组件
            // 使用 @SpringJUnitConfig注解后不用再去获取IoC容器以及读取bean对象，可直接使用
        // 使用组件
        System.out.println(a);
    }
}
