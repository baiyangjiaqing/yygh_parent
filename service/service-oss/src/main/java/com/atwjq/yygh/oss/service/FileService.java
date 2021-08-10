package com.atwjq.yygh.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-29-16:31
 */
public interface FileService {
    //上传文件到阿里云oss
    String upload(MultipartFile file);
}
