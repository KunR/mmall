package com.individual.service;

import com.individual.common.ServerResponse;
import com.individual.pojo.User;

/**
 * Created by Yangzu on 2018/8/12
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);
}
