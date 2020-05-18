package com.web.framework.service.impl;

import com.web.framework.entity.User;
import com.web.framework.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author LiH
 * @description 用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String addUser(User user) {
        // 直接编写业务逻辑
        return "success";
    }
}
