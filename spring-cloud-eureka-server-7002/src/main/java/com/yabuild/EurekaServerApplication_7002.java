package com.yabuild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 15:23 2019/1/11
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication_7002.class,args);
    }
}
