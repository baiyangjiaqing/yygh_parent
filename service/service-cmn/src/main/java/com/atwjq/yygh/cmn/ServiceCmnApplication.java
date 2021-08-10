package com.atwjq.yygh.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-15-16:08
 */
@ComponentScan(basePackages = {"com.atwjq.yygh"})
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }
}
