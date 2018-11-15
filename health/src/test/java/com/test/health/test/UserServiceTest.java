package com.test.health.test;

import com.test.health.model.User;
import com.test.health.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zjb
 * @date 2018/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;
    @Test
    public void addUser() {
        User user = new User();
        user.setPassword("admin");
        user.setName("admin");
//        user.setToken("8961289648921469821");

        userService.addUser(user);

    }
}