package ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

public class JdbcConfig {
    @Bean
    public DataSource dataSource(@Value("${name}") String name){
        System.out.println(name);
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc://mysql:localhost:3306/mybatis");
        ds.setUsername("root");
        ds.setPassword("zzy0927");
        return ds;
    }
}