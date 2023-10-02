package ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration          // 相当于一个配置文件
@ComponentScan("ssm")   // 扫描哪个包的组件
@PropertySource("classpath:jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfig {
    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc://mysql:localhost:3306/mybatis");
        ds.setUsername("root");
        ds.setPassword("zzy0927");
        return ds;
    }
}