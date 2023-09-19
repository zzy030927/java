package com.carProgram.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.carProgram.pojo.AliOOSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 */
@Component      // 将此类交给IOC容器管理
public class AliOSSUtils {

    @Autowired
    private AliOOSProperties aliOOSProperties;

    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile file) throws IOException {
        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 获取阿里云OSS参数
        String endpoint = aliOOSProperties.getEndpoint();
        String accessKeyId = aliOOSProperties.getAccessKeyId();
        String accessKeySecret = aliOOSProperties.getAccessKeySecret();
        String bucketName = aliOOSProperties.getBucketName();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf("."));

        //上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }

}
