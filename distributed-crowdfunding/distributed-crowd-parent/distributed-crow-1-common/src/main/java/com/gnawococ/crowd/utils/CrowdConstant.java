package com.gnawococ.crowd.utils;

/**
 * @program: distributed-crowdfunding
 * @description: 常量定义
 * @author: wang_sir
 * @create: 2020-06-06 14:05
 **/
public class CrowdConstant {
    /**
     * 保存redis中存储的手机验证码
     */
    public static final String REDIS_RANDOM_CODE_PREFIX="RANDOM_CODE_";

    public static final String MESSAGE_REDIS_KEY_INVALID = "存入redis的key或者value不是有效的字符串";
    public static final String MESSAGE_REDIS_KEY_TIME_OUT_INVALID ="不接受o或null的时间，请正确设置保存时间" ;
    public static final String MESSAGE_REDIS_RESULT_INVALID = "返回的结果值无效" ;
    public static final String MESSAGE_PHONE_NUM_INVALID = "手机号码有误，请重新输入" ;
    public static final String MESSAGE_SAVE_REDIS_FAILED = "验证码保存失败";
    public static final String MESSAGE_LOGIN_ACCT_INVALID = "当前查询的账户信息有误";
    public static final String MESSAGE_MEMBER_SAVE_FAILED = "账户保存失败";
    public static final String MESSAGE_CODE_INVALID = "验证码无效" ;
    public static final String MESSAGE_CODE_NOT_MATCH = "验证码不匹配";
    public static final String MESSAGE_CODE_NOT_EXISTS ="验证码不存在或已过期" ;
    public static final String MESSAGE_LOGIN_ACCT_OCCUPY = "当前账号被占用";
}
