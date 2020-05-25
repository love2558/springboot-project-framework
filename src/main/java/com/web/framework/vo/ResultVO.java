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

    private ResultVO(){
    }

    private ResultVO(int code,String msg,T data){
        this.code = code;
        this.success = code == ResultCode.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess(){
        return success;
    }

    public static class ResultGenerator<T> {

        public ResultVO<T> genSuccessResult(){
            return new ResultVO<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),null);
        }

        public ResultVO<T> genSuccessResult(T data){
            return new ResultVO<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
        }

        public ResultVO<T> genFailResult(ResultCode resultCode){
            return new ResultVO<>(resultCode.getCode(),resultCode.getMsg(),null);
        }

        public ResultVO<T> genFailResult(APIException e){
            return new ResultVO<>(e.getCode(),e.getMsg(),null);
        }

        public ResultVO<T> genResult(int code,String msg,T data){
            return new ResultVO<>(code,msg,data);
        }
    }
}
