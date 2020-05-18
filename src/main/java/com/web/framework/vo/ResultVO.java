package com.web.framework.vo;

import com.web.framework.enums.ResultCode;
import com.web.framework.exception.APIException;
import lombok.Getter;

/**
 * @author LiH
 * @description 自定义统一响应体
 */
@Getter
public class ResultVO<T> {

    /** 状态码 200：成功，其它：登录失败 */
    private int code;

    /** 是否成功 */
    private boolean success;

    /** 错误信息 */
    private String msg;

    /** 数据 */
    private T data;

    public ResultVO(){
    }

    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.success = code == ResultCode.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    private ResultVO<T> init(int code, String msg, T data){
        this.code = code;
        this.success = code == ResultCode.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
        return this;
    }

    public boolean isSuccess(){
        return success;
    }

    public ResultVO<T> success(T data){
        return init(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public ResultVO<T> fail(ResultCode code){
        return init(code.getCode(),code.getMsg(),null);
    }

    public ResultVO<T> fail(ResultCode code,T data){
        return init(code.getCode(),code.getMsg(),data);
    }

    public ResultVO<T> fail(APIException e){
        return init(e.getCode(),e.getMsg(),null);
    }
}
