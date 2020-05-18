package com.web.framework.enums;

import lombok.Getter;

/**
 * @author LiH
 * @description 响应码枚举
 */
@Getter
public enum ResultCode {

    FAILED(0, "操作失败"),

    SUCCESS(200, "操作成功"),

    ERROR(500, "服务繁忙，请稍后再试"),

    VALIDATE_FAILED(1000, "参数校验失败"),



    ;

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
