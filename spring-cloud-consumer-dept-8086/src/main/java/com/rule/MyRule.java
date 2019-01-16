package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 14:30 2019/1/14
 * @Modified By:
 */
@Configuration
public class MyRule  {

    @Bean
    public IRule userDefinedRule() {
        return new RandomRule_ZY();
    }
}
