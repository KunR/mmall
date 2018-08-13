package com.individual.service.impl;

import com.individual.common.ServerResponse;
import com.individual.dao.UserMapper;
import com.individual.pojo.User;
import com.individual.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Yangzu on 2018/8/12
 */
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
        return null;
    }
}
