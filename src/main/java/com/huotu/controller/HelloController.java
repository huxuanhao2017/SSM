package com.huotu.controller;

import com.huotu.dao.UserDao;
import com.huotu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huxuanhao on 2017-06-13.
 */
@Controller
public class HelloController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    public String hello(Model model) {
        String email = "sam@balabala.com";
        String name = userDao.queryUserNameByEmail(email);
        User user = userDao.queryUserInfoByEmail(email);
        model.addAttribute("hello", "name is " + name);
        model.addAttribute("world", "id is " + user.getUserId());
        return "hello";
    }
}
