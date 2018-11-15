package com.test.health.controller;

import com.test.health.model.User;
import com.test.health.service.UserService;
import com.test.health.vo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/add")
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }

    @GetMapping("/user/login")
    public Result loginIn(@RequestParam String name,
                          @RequestParam String password,
                          HttpServletResponse response){
        try {

            if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
                return Result.fail();
            }
            User user = userService.findUserBy(name, password);
            if(user != null){
                return Result.success();
            }
//            Student student=  studentService.findByNameAndPwd(name, password);
//            if(student != null){
//                String pwd = name + password + System.currentTimeMillis();
//                String md = Hashing.md5().newHasher().putString(pwd, Charsets.UTF_8).hash().toString();
//                student.setToken(md);
//                studentService.saveStudent(student);
//                Cookie cookie = new Cookie(StudentLogInterceptor.TOKEN_NAME, md);//创建新cookie
//                cookie.setMaxAge(12 * 3600);
//                cookie.setPath("/");
//                response.addCookie(cookie);
//                return Result.success();
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }
}
