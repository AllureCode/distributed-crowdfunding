package com.gnawococ.crowd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @program: distributed-crowdfunding
 * @description: 封装结果的类
 * @author: wang_sir
 * @create: 2020-06-05 10:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> implements Serializable {
    private String result;
    private String message;
    private T data;

    public static final  String SUCCESS="SUCCESS";
    public  static final  String FAILED = "FAILED";
    public static final String NO_MSG="NO_MSG";
    public static final String NO_DATA = "NO_DATA";

    public static ResultEntity<String> successNoData(){
        return new ResultEntity<>(SUCCESS,NO_MSG,NO_DATA);
    }

    public static<T> ResultEntity<T> successWithData(T data){
        return new ResultEntity<>(SUCCESS,NO_MSG,data);
    }

    public static <T> ResultEntity<T> failed(String message){
        return new ResultEntity<>(FAILED,message,null);
    }
}
