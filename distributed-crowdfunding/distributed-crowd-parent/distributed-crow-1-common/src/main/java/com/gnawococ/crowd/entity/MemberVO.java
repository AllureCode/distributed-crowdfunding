package com.gnawococ.crowd.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: distributed-crowdfunding
 * @description:  注册相关
 * @author: wang_sir
 * @create: 2020-06-07 12:38
 **/
@Data
@Accessors(chain = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements Serializable {
    private String loginacct;
    private String userpswd;
    private String phoneNum;
    private String randomCode;
}
