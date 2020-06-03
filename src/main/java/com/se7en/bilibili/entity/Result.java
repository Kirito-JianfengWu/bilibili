package com.se7en.bilibili.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Jianfeng Wu on 2020-03-31.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String errorCode = "0";

    private static final String successCode = "1";

    private String code;

    private String msg;

    private Object data;

    public static String error(String msg){
        return JSONObject.toJSONString(Result.builder().code(errorCode).msg(msg).build());
    }

    public static String success(String msg,Object data){
        return JSONObject.toJSONString(Result.builder().code(successCode).msg(msg).data(data).build());
    }

}