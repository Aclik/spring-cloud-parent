package com.yxbuild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 9:13 2019/1/10
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProviderApplication_8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApplication_8001.class,args);
    }
}
