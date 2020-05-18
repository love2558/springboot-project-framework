package com.web.framework.entity;

import com.web.framework.annotation.ExceptionCode;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author LiH
 * @description 用户实体类
 */
@Data
public class User {
    @NotNull(message = "用户id不能为空")
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    @ExceptionCode(value = 100001, message = "账号验证错误")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    @ExceptionCode(value = 100002, message = "密码验证错误")
    private String password;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @ExceptionCode(value = 100003, message = "邮箱验证错误")
    private String email;
}
