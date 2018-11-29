package com.test.health.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.health.dao.mapper.AppointmentMapper;
import com.test.health.dao.mapper.SessionMapper;
import com.test.health.model.Appointment;
import com.test.health.model.Session;
import com.test.health.vo.SessionRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class SessionService {

    @Resource
    private SessionMapper sessionMapper;

    @Resource
    private AppointmentMapper appointmentMapper;

    /**
     * list all session
     * @param request
     * @return
     */
    public List<Appointment> listSession(SessionRequest request){
        if(request.getSize()==null){
            request.setSize(20);
        }
        if(request.getPage()==null){
            request.setPage(1);
        }
        Date start = null;
        Date end = null;
        if(request.getStart() != null){
            start = new Date(request.getStart());
        }
        if(request.getEnd() != null){
            end = new Date(request.getEnd());
        }
        List<Appointment> list = appointmentMapper.listAvailableApp(request.getName(), start, end);
        return list;
    }


}
