package com.gnawococ.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: distributed-crowdfunding
 * @description: registry-center启动类
 * @author: wang_sir
 * @create: 2020-05-22 19:14
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class Registry8001_APP {
    public static void main(String[] args) {
        SpringApplication.run(Registry8001_APP.class,args);
    }
}
