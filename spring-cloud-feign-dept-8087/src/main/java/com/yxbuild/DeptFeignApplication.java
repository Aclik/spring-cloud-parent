package com.yxbuild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 11:12 2019/1/10
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.yxbuild"})
@ComponentScan(value = "com.yxbuild")
public class DeptFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptFeignApplication.class,args);
    }
}
