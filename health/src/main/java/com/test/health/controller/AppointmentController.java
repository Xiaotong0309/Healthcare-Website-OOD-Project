package com.test.health.controller;

import com.test.health.service.SessionService;
import com.test.health.vo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AppointmentController {

    @Resource
    private SessionService sessionService;

    @GetMapping("/api/session/list")
    public Result listSession(@RequestParam(defaultValue = "10")Integer size,
                              @RequestParam(defaultValue = "1")Integer page){
        try {
            return Result.success(sessionService.listSession(page, size));
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }
}
