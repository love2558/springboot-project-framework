package com.web.framework.vo;

import com.web.framework.enums.ResultCode;
import com.web.framework.exception.APIException;
import lombok.Getter;

/**
 * @author LiH
 * @description 自定义统一响应体
 */
@Getter
public class ResultVO_bak<T> {

    /** 状态码 200：成功，其它：登录失败 */
    private int code;

    /** 是否成功 */
    private boolean success;

    /** 错误信息 */
    private String msg;

    /** 数据 */
    private T data;

    public ResultVO_bak(){
    }

    public ResultVO_bak(int code, String msg, T data) {
        this.code = code;
        this.success = code == ResultCode.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    private ResultVO_bak<T> init(int code, String msg, T data){
        this.code = code;
        this.success = code == ResultCode.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
        return this;
    }

    public boolean isSuccess(){
        return success;
    }

    public ResultVO_bak<T> success(T data){
        return init(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public ResultVO_bak<T> fail(ResultCode code){
        return init(code.getCode(),code.getMsg(),null);
    }

    public ResultVO_bak<T> fail(ResultCode code,T data){
        return init(code.getCode(),code.getMsg(),data);
    }

    public ResultVO_bak<T> fail(APIException e){
        return init(e.getCode(),e.getMsg(),null);
    }
}
