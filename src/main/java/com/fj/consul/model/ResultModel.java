package com.fj.consul.model;

import com.fj.consul.enums.RequestResultEnum;
import lombok.Data;

@Data
public class ResultModel<T> {
    private int code;
    private String msg;
    private T data;

    public ResultModel(RequestResultEnum requestResultEnum){
        this.code = requestResultEnum.getCode();
        this.msg = requestResultEnum.getMsg();
    }

    public ResultModel() {
    }

    public ResultModel(RequestResultEnum requestResultEnum, String msg) {
        this.code = requestResultEnum.getCode();
        this.msg = requestResultEnum.getMsg() + " " + msg;
    }
}
