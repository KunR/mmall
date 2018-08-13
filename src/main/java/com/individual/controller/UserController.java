package com.individual.controller;

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

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public Object login(String loginName, String password, HttpSession session) {
        return "";
    }
}
