package com.gxy.service.impl;

import com.gxy.controller.UserController;
import com.gxy.mapper.UserMapper;
import com.gxy.pojo.User;
import com.gxy.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.dc.pr.PRError;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {

        log.info("---findAll---");
        return userMapper.findAll();
    }
}
