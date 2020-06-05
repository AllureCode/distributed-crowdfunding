package com.gnawococ.crowd;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: distributed-crowdfunding
 * @description: 测试短信发送
 * @author: wang_sir
 * @create: 2020-05-29 09:34
 **/
public class ShowMessage {
    @Test
    public void testMessage() throws Exception {
        //调用短信API时发送请求的目标地址
        String host = "https://feginesms.market.alicloudapi.com";
        //具体功能路径
        String path = "/codeNotice";
        //请求方式
        String method = "GET";
        String appcode = "61f2eaa3c43e42ad82c26fbbe1061311";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE" + appcode);
        Map<String, String> query = new HashMap<>();
        query.put("param", "123456");
        query.put("phone", "15398069231");
        query.put("sign", "1");
        query.put("skin", "1");
        try {
            HttpResponse response = HttpUtils.doGet(host, path,method , headers, query);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
