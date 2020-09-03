package com.finalhao.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @date:2020/9/3 10:57
 * @author:hao.fang Email:
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.finalhao.system.dao")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
