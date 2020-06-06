package com.gnawococ.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: distributed-crowdfunding
 * @description:
 * @author: wang_sir
 * @create: 2020-05-22 21:18
 **/
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class MemberManager9004_APP {
    public static void main(String[] args) {
        SpringApplication.run(MemberManager9004_APP.class,args);
    }
}
