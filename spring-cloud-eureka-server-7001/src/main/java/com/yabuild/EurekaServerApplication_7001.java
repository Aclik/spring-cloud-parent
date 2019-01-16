package com.yabuild;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 17:18 2019/1/10
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication_7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication_7001.class,args);
    }
}
