package com.atwjq.yygh.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-24-18:16
 */
@Configuration
@MapperScan("com.atwjq.yygh.user.mapper")
public class UserConfig {
}
