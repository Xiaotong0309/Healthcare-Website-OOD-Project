package com.test.health.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.test.health.dao.mapper.AppointmentMapper;
import com.test.health.dao.mapper.UserMapper;
import com.test.health.info.UserInfo;
import com.test.health.interceptor.LoginInterceptor;
import com.test.health.model.Appointment;
import com.test.health.model.User;
import com.test.health.service.UserService;
import com.test.health.vo.Result;
import com.test.health.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;


@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private AppointmentMapper appointmentMapper;

    /**
     * list all patient by login admin
     * @return
     */
    @GetMapping("/api/patient/list")
    public Result listPatient(){
        List<User> list = userMapper.selectList(new QueryWrapper<User>().eq("type",1));
        List<UserVO> voList = new LinkedList<>();
        if(list != null){
            for(User user : list){
                List<Appointment> appointments = appointmentMapper.selectList(new QueryWrapper<Appointment>().eq("patient_id", user.getId()));
                UserVO vo = new UserVO();
                BeanUtils.copyProperties(user, vo);
                if(!CollectionUtils.isEmpty(appointments)){
                    for(Appointment app : appointments){
                        UserVO t = new UserVO();
                        BeanUtils.copyProperties(user, t);
                        t.setAppId(app.getId());
                        t.setDoctorName(app.getDoctorName());
                        t.setTime(app.getTime());
                        t.setStatus(app.getStatus());
                        voList.add(t);
                    }
                }else {
                    voList.add(vo);
                }
            }
        }
        return Result.success(voList);
    }

    /**
     * delete a doctor by admin
     * @param id the id of doctor
     * @return
     */
    @GetMapping("/api/doctor/delete")
    public Result deleteDoctor(@RequestParam Long id){
        userMapper.deleteById(id);
        return Result.success();
    }

    /**
     * add doctor by doctor
     * @param user information of the doctor
     * @return
     */
    @PostMapping("/api/doctor/add")
    public Result addDoctor(@RequestBody User user){
        user.setType(2);
        userMapper.insert(user);
        return Result.success();
    }

    /**
     * list doctor by admin
     * @return
     */
    @GetMapping("/api/doctor/list")
    public Result listDoctor(){
        List<User> list = userMapper.selectList(new QueryWrapper<User>().eq("type",2));
        return Result.success(list);
    }

    /**
     * sign up a patient
     * @param user information of a patient
     * @return
     */
    @PostMapping("/user/add")
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }

    /**
     * login by patient , doctor and admin
     * @param name
     * @param password
     * @param response
     * @return
     */
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
                String md = Hashing.md5().newHasher().putString(password+name, Charsets.UTF_8).hash().toString();
                user.setToken(md);
                userMapper.updateById(user);
                Cookie cookie = new Cookie(LoginInterceptor.TOKEN_NAME, md);//创建新cookie
                cookie.setMaxAge(12 * 3600);
                cookie.setPath("/");
                response.addCookie(cookie);
                return Result.success(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * get the current login user's information
     * @return
     */
    @GetMapping("/api/user/current")
    public Result getUserInfo(){
        try {
            return Result.success(UserInfo.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * logout current user
     * @param httpServletResponse
     * @return
     */
    @GetMapping("/api/user/logout")
    public Result logout(HttpServletResponse httpServletResponse) {
        try {
            Cookie cookie = new Cookie(LoginInterceptor.TOKEN_NAME,"");//创建新cookie
            cookie.setMaxAge(0);
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail();
    }
}
