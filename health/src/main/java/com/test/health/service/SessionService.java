package com.test.health.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.health.dao.mapper.SessionMapper;
import com.test.health.model.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SessionService {

    @Resource
    private SessionMapper sessionMapper;

    public List<Session> listSession(Integer page, Integer size){
        PageHelper.startPage(page, size);
        Page<Session> pageResult = sessionMapper.listSession();
        return pageResult.getResult();
    }
}
