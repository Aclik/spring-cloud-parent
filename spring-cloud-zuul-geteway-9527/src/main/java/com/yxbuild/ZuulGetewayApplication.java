package com.yxbuild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 16:50 2019/1/15
 * @Modified By:
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGetewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGetewayApplication.class,args);
    }
}
