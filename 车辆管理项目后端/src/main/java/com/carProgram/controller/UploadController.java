package com.carProgram.controller;

import com.carProgram.pojo.Result;
import com.carProgram.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    // 本地保存文件方法
    @PostMapping("/downLocal")                         // MultipartFile 类用于接受文件，参数名要与前端参数名一致
    // 文件大小不超过1M,如果上传超过1M大小的文件时，在配置文件中配置参数
    public Result upload(MultipartFile file) throws IOException {
        log.info("本地文件上传");
        // getOriginalFilename()获取文件名, getName()方法为获取表单项的名字
        String fileName = file.getOriginalFilename();
        // 构造唯一文件名（不能重复）- uuid（通用唯一识别码）
        int index = Objects.requireNonNull(fileName).lastIndexOf('.');      // 获取文件后缀
        fileName = fileName.substring(index);           // 截取文件后缀
        String newFileName = UUID.randomUUID().toString() + fileName;   // 使用 UUID生成唯一标识码，再将后缀拼接上去
        // 将文件保存在本地
        file.transferTo(new File("E:\\java\\java_data\\carManagerPro\\" + newFileName));
        return Result.success();
    }

    // 阿里云OOS保存文件方法
    @PostMapping("/downAli")
    public Result upload1(MultipartFile file) throws IOException {
        log.info("阿里云OOS文件保存");
        String url = aliOSSUtils.upload(file);     // 返回文件的url路径
        return Result.success(url);
    }


}

