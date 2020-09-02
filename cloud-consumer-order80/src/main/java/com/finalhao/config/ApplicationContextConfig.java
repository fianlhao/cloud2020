package com.finalhao.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @date:2020/8/19 22:14
 * @author:hao.fang Email:
 * Description:
 */
@Configuration
public class ApplicationContextConfig {
    @LoadBalanced //通过loadbalanced赋予RestTemplate负载均衡的能力
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
