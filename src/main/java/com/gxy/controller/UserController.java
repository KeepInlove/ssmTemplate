package com.gxy.controller;

import com.gxy.common.DynamicDataSource;
import com.gxy.pojo.User;
import com.gxy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * html,jsp类型
 */
@Controller
public class UserController {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getAll(Model model){

        log.info("-----postgresqlDataSource----------");
        DynamicDataSource.clearCustomerDBType();
        DynamicDataSource.setCustomerDBType(DynamicDataSource.postgresqlDataSource);
        List<User> userList = userService.findAll();
        model.addAttribute("list",userList);
        return "userList";
    }
}
