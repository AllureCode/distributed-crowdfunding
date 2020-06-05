package com.gnawococ.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: distributed-crowdfunding
 * @description: redis启动类
 * @author: wang_sir
 * @create: 2020-05-22 20:51
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Redis9003_APP {
    public static void main(String[] args) {
        SpringApplication.run(Redis9003_APP.class,args);
    }
}
