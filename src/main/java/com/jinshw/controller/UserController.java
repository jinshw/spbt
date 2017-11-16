package com.jinshw.controller;

import com.alibaba.fastjson.JSONArray;
import com.jinshw.pojo.User;
import com.jinshw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("user")
public class UserController {

    private Logger logger = Logger.getLogger("info");

    @Autowired
    private UserService userService;

    @RequestMapping("getUserById")
    @ResponseBody
    public User getUserById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(id);
        if (user != null) {
            logger.info(user.getName());
        }
        return user;
    }

    @RequestMapping("userlist")
    public String hello(ModelMap model) {
        model.put("time", new Date());
        model.put("message", "testgggggg");
        model.put("age",51288);
        return "/pages/userlist";
    }
}