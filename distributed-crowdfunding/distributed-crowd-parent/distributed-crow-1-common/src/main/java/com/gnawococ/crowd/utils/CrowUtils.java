package com.gnawococ.crowd.utils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: distributed-crowdfunding
 * @description:
 * @author: wang_sir
 * @create: 2020-06-03 10:40
 **/
public class CrowUtils {
    /**
     * @Author: wang_sir
     * @Description: 验证集合是否有效
     * @Date: 10:41 2020/6/3
     * @Param: [c]
     * @return: boolean
     **/
    public static <E> boolean collectionEffectiveCheck(Collection<E> c) {
        return (c != null) && (c.size() > 0);
    }

    /**
     * @Author: wang_sir
     * @Description: 验证字符串是否有效
     * @Date: 10:43 2020/6/3
     * @Param: [source]
     * @return: boolean
     **/
    public static boolean strEffectiveCheck(String source) {
        return (source != null) && (source.length() > 0);
    }

    /**
     * @Author: wang_sir
     * @Description: 生成随机数
     * @Date: 10:47 2020/6/3
     * @Param: [length]
     * @return: java.lang.String
     **/
    public static String randomCode(int length) {
        if (length <= 0) {
            throw new RuntimeException("长度有误");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            //生成随机数
            double doubleRandom = Math.random();
            //调整
            int integerRandom = (int) (doubleRandom * 10);
            //拼接
            builder.append(integerRandom);
        }
        return builder.toString();
    }

    /**
     * @Author: wang_sir
     * @Description: 发送短信验证
     * @Date: 10:53 2020/6/3
     * @Param: [appcode, randomCode, phoneNum]
     * @return: void
     **/
    public static void sendShortMessage(String appcode,String randomCode, String phoneNum) throws Exception {
        //调用短信API时发送请求的目标地址
        //String host = "https://edisim.market.alicloudapi.com";
        String host = "https://edisim.market.alicloudapi.com";

        //具体功能路径
        String path = "/comms/sms/sendmsg";
        //请求方式
        String method = "POST";
        // String appcode = "61f2eaa3c43e42ad82c26fbbe1061311";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE " + appcode);
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        query.put("param", randomCode);
//        query.put("phone", phoneNum);
//        query.put("sign", "1");
//        query.put("skin", "1");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("callbackUrl", "http://test.dev.esandcloud.com");
        bodys.put("mobile", phoneNum);
        bodys.put("templateID", "0000000");
        bodys.put("templateParamSet", "["+randomCode+',' +15+"]");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys,bodys);
            System.out.println(response.toString());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
