package com.individual.service.impl;

import com.individual.common.ServerResponse;
import com.individual.dao.UserMapper;
import com.individual.pojo.User;
import com.individual.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by Yangzu on 2018/8/12
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper mapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        //1.检查用户是否存在
        int resultCount = mapper.checkByUsername(username);
        if (resultCount == 0) {
              return ServerResponse.createByError("用户名不存在");
        }
        //2.用户存在判断密码是否正确
        User user = mapper.checkByUsernameAndPassword(username, password);
        if (user == null) {
            return ServerResponse.createByError("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        //判断用户名是否已存在
        int resultCount = mapper.checkByUsername(user.getUsername());
        if (resultCount > 0) {
            return ServerResponse.createByError("用户名已存在");
        }
        //注册用户
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        mapper.insert(user);
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("注册成功");
    }
}
