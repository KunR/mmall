package com.individual.controller;

import com.individual.common.Const;
import com.individual.common.ServerResponse;
import com.individual.pojo.User;
import com.individual.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Yangzu on 2018/8/12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl iUserService;

    /**
     * 登陆
     * @param loginName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(String loginName, String password, HttpSession session) {
        ServerResponse<User> login = iUserService.login(loginName, password);
        if (login.isSuccess()) {
            session.setAttribute(Const.CURRENT, login.getData());
        }
        return login;
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT);
        return ServerResponse.createBySuccess();
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    public ServerResponse<String> register(@RequestBody User user) {
        ServerResponse<String> register = iUserService.register(user);
        return register;
    }
}
