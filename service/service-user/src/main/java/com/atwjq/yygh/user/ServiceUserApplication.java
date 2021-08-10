package com.atwjq.yygh.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-24-17:51
 */
@ComponentScan(basePackages = "com.atwjq")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atwjq.yygh")
@SpringBootApplication
public class ServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }
}

