package com.example.webui.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//封装前端页面的bean
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Object data;

    private Integer code;

    private String message;

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);

        return result;
    }

    public static Result fail(){
        Result result = new Result();
        result.setCode(400);
        result.setMessage("fail");

        return result;
    }
}
