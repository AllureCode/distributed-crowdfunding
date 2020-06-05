package com.gnawococ.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: distributed-crowdfunding
 * @description:
 * @author: wang_sir
 * @create: 2020-05-22 21:18
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MemberManager8004_APP {
    public static void main(String[] args) {
        SpringApplication.run(MemberManager8004_APP.class,args);
    }
}
