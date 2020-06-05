package com.gnawococ.crowd.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberPO implements Serializable {
    private Integer id;

    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private Byte authstatus;

    private Byte usertype;

    private String realname;

    private String cardnum;

    private Byte accttype;

}