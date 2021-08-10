package com.atwjq.yygh.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-05-17:47
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atwjq")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atwjq.yygh.cmn.client")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class,args);
    }
}
