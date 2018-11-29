package com.test.health.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    /**
     * add a user
     * @param user
     * @return
     */
    public boolean addUser(User user){
        userMapper.insert(user);
        return true;
    }

    /**
     * find user by username and password
     * @param username
     * @param password
     * @return
     */
    public User findUserBy(String username, String password){

        User user = userMapper.selectBy(username, password);
        return user;
    }

    /**
     * check if the token is valid
     * @param token
     * @return
     */
    public User isTokenValid(String token){
        User result = userMapper.selectOne(new QueryWrapper<User>().eq("token",token));
        return result;
    }
}
