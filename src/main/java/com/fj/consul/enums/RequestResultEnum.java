package com.fj.consul.enums;

import lombok.Getter;

@Getter
public enum RequestResultEnum {

    SUCCESS(200,"成功"),

    FAIL_PARAM_ERROR(1, "参数错误"),

    ADD_PMS_ERROR(1,"编号不能为空")

    ;

    private int code;
    private String msg;

    RequestResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
