package ssm.src;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ssm.config.JdbcConfig;
import ssm.config.SpringConfig;

@SpringBootApplication
public class SsmApplication {
    public static void main(String[] args) {
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcConfig jdbcConfig = context.getBean(JdbcConfig.class);
        System.out.println(jdbcConfig);
    }
}