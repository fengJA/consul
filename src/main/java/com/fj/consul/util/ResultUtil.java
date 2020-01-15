package com.fj.consul.util;

import com.fj.consul.enums.RequestResultEnum;
import com.fj.consul.model.ResultModel;
import lombok.Data;

@Data
public class ResultUtil {
    public static ResultModel success() {
        return new ResultModel(RequestResultEnum.SUCCESS);
    }

    public static <T> ResultModel success(T t) {
        ResultModel resultModel = new ResultModel(RequestResultEnum.SUCCESS);
        resultModel.setData(t);
        return resultModel;
    }

    public static ResultModel error(RequestResultEnum requestResultEnum) {
        return new ResultModel(requestResultEnum);
    }

    public static ResultModel error() {
        return new ResultModel(RequestResultEnum.FAIL_PARAM_ERROR);
    }

    public static ResultModel error(RequestResultEnum requestResultEnum, String msg) {
        return new ResultModel(requestResultEnum, msg);
    }
}
