package com.src;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class TestMethod {

    private Logger logger = LoggerFactory.getLogger(TestMethod.class);      // 创建 日志Logger实例

    @Test
    public void test() {
        // 加载spring配置文件，进行对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);
        // 测试
        user.add();
        logger.info("hahaha");
        log.info("666");
    }
}
