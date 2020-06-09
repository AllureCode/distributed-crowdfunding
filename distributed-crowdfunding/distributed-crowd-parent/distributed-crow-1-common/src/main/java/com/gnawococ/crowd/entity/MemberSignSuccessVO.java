package com.gnawococ.crowd.entity;

import lombok.*;
import java.io.Serializable;

/**
 * @program: distributed-crowdfunding
 * @description: 登录成功封装的结果
 * @author: wang_sir
 * @create: 2020-06-08 15:47
 **/
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignSuccessVO implements Serializable {
    private String username;
    private String email;
    private String token;
}
