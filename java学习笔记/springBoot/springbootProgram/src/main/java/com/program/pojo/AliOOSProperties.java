package com.program.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
// 引入配置文件中配置的四个属性 例子：@Value("${aliyun.oss.endpoint}")，这个注解写在 endpoint属性上
// 或者使用ConfigurationProperties(prefix = "aliyun.oss"),aliyun.oss为配置属性的前缀
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOOSProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
