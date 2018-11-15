package com.test.health.service;

import com.test.health.dao.mapper.UserMapper;
import com.test.health.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public boolean addUser(User user){
        userMapper.insert(user);
        return true;
    }

    public User findUserBy(String username, String password){
        Map<String, String> map = new HashMap<>();
        User queryUser = new User();
        queryUser.setName(username);
        queryUser.setPassword(password);
        User user = userMapper.selectOne(queryUser);
        return user;
    }
}
