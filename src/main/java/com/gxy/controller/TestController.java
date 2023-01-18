package com.gxy.controller;

import com.gxy.common.CommonResp;
import com.gxy.common.DynamicDataSource;
import com.gxy.pojo.User;
import com.gxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public CommonResp test() {
        //一通操作......
        //切换数据库
        List<User> userList = userService.findAll();
        CommonResp resp=new CommonResp();
        resp.setContent(userList);
        resp.setMessage("请求成功");
        //又一通操作......
        return resp;
    }
}

