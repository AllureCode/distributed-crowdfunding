package com.gnawococ.crowd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: distributed-crowdfunding
 * @description: 加密配置类
 * @author: wang_sir
 * @create: 2020-06-07 13:52
 **/
@Configuration
public class EncryptionConfig {
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
