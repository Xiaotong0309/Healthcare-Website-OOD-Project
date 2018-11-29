package com.test.health.controller;

import com.test.health.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommonController {
    /**
     * the api to check current token is valid
     * @return
     */
    @GetMapping("/api/check_token")
    @ResponseBody
    public Result checkToken() {
        return Result.success();
    }
}
