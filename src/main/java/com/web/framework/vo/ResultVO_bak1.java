package com.web.framework.vo;

import com.web.framework.enums.ResultCode;
import com.web.framework.exception.APIException;
import lombok.Getter;

/**
 * @author LiH
 * @description 自定义统一响应体
 */
@Getter
public class ResultVO_bak1<T> {

    /** 状态码 200：成功，其它：登录失败 */
    private int code;

    /** 是否成功 */
    private boolean success;

    /** 错误信息 */
    private String msg;

    /** 数据 */
    private T data;

    private ResultVO_bak1(){
    }

    private ResultVO_bak1(int code,String msg,T data){
        this.code = code;
        this.success = code == ResultCode.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess(){
        return success;
    }

    public static class ResultBuilder<T> {
        /** 状态码 200：成功，其它：登录失败 */
        private int code;

        /** 错误信息 */
        private String msg;

        /** 数据 */
        private T data;

        public ResultBuilder<T> withCode(int code){
            this.code = code;
            return this;
        }

        public ResultBuilder<T> withMsg(String msg){
            this.msg = msg;
            return this;
        }

        public ResultBuilder<T> withResultCode(ResultCode resultCode){
            this.code = resultCode.getCode();
            this.msg = resultCode.getMsg();
            return this;
        }

        public ResultBuilder<T> withException(APIException e){
            this.code = e.getCode();
            this.msg = e.getMsg();
            return this;
        }

        public ResultBuilder<T> withData(T data){
            this.data = data;
            return this;
        }

        public ResultVO_bak1<T> build(){
            return new ResultVO_bak1<>(code,msg,data);
        }
    }
}
