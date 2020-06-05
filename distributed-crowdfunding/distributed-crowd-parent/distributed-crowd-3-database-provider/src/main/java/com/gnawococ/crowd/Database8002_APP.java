package com.gnawococ.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: distributed-crowdfunding
 * @description: 8002启动类
 * @author: wang_sir
 * @create: 2020-05-22 19:54
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.gnawococ.crowd.mapper")
public class Database8002_APP {
    public static void main(String[] args) {
        SpringApplication.run(Database8002_APP.class,args);
    }
}
