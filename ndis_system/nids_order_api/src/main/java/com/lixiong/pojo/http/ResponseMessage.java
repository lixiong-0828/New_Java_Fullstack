package com.lixiong.pojo.http;

import lombok.Data;

@Data
public class ResponseMessage <T>{

    private String message;
    private T data;
    private int code;

    public ResponseMessage(int code, String message, T data) {
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static <T> ResponseMessage success(T data){
        return new ResponseMessage<T>(200, "success", data);
    }

    public static <T> ResponseMessage created(T data){
        return new ResponseMessage<T>(201, "created", data);
    }

    public static <T> ResponseMessage error(int code, String message, T data){
        return new ResponseMessage<T>(code, message, data);
    }

    public static <T> ResponseMessage error(int code, String message){
        return new ResponseMessage<T>(code, message,null);
    }

}
