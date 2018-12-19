package com.test.health.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.test.health.dao.mapper.AppointmentMapper;
import com.test.health.dao.mapper.SessionMapper;
import com.test.health.dao.mapper.UserMapper;
import com.test.health.info.UserInfo;
import com.test.health.model.Appointment;
import com.test.health.model.User;
import com.test.health.service.SessionService;
import com.test.health.vo.AppointmentVO;
import com.test.health.vo.Result;
import com.test.health.vo.SessionRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
public class AppointmentController {

    @Resource
    private SessionService sessionService;

    @Resource
    private SessionMapper sessionMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private AppointmentMapper appointmentMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss z", Locale.US);

    /**
     * get all session for patient
     * @param request
     * @return
     */
    @GetMapping("/api/session/list")
    public Result listSession(SessionRequest request){
        try {
            return Result.success(sessionService.listSession(request));
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * get all appointment for patient
     * @return
     */
    @GetMapping("/api/app/all/list")
    public Result getAllAppList(){
        List<Appointment> appointments = appointmentMapper.selectList(new QueryWrapper<Appointment>().eq("status",1));
        List<AppointmentVO> voList = new LinkedList<>();
        if(appointments != null){
            for(Appointment app : appointments){
                AppointmentVO vo = new AppointmentVO();
                BeanUtils.copyProperties(app,vo);
                User p = userMapper.selectById(app.getPatientId());
                vo.setPatientName(p.getName());
                voList.add(vo);
            }
        }
        return Result.success(voList);
    }

    /**
     * delete session by patient
     * @param sessionId
     * @return
     */
    @GetMapping("/api/session/delete")
    public Result deleteSession(@RequestParam Long sessionId){
        try {
            appointmentMapper.deleteById(sessionId);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * get all session by doctor
     * @return
     */
    @GetMapping("/api/session/doctor/list")
    public Result listDoctorSession(){
        try {
            User user = UserInfo.get();
            Map map = new HashMap();
            map.put("doctor_id", user.getId());
            map.put("status",0);
            List<Appointment> list = appointmentMapper.selectList(new QueryWrapper<Appointment>().allEq(map));
            return Result.success(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * get all appointment by doctor
     * @return
     */
    @GetMapping("api/app/doctor/list")
    public Result listDoctorApp(){
        try {
            User user = UserInfo.get();
            List<Appointment> list = appointmentMapper.selectDocAppList(user.getId());

            return Result.success(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * add session by doctor
     * @param time
     * @return
     */
    @GetMapping("/api/session/add")
    public Result addSession(@RequestParam String time){
        try {
            System.out.println(time);
            Date date = sdf.parse(time);
            User user = UserInfo.get();
            Appointment appointment = new Appointment();
            appointment.setDoctorId(user.getId());
            appointment.setDoctorName(user.getName());
            appointment.setTime(new Date(date.getTime() + 6*3600*1000L));
            appointmentMapper.insert(appointment);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * list current appointment schedule by the login patient
     * @return
     */
    @GetMapping("/api/app/schedule/list")
    public Result listScheduleApp(){
        try {
            User user = UserInfo.get();
            List<Appointment> list = appointmentMapper.selectList(new QueryWrapper<Appointment>().eq("patient_id", user.getId()));
            return Result.success(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * cancel the appointment by the login patient
     * @param sessionId
     * @return
     */
    @GetMapping("/api/app/cancel")
    public Result cancelApp(@RequestParam("sessionId")Long sessionId){
        try {
            Appointment appointment = appointmentMapper.selectById(sessionId);
            appointment.setStatus(0);
            appointment.setPatientId(-1L);
            appointmentMapper.updateById(appointment);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * schedule the session by the login patient
     * @param sessionId the id of the session
     * @return
     */
    @GetMapping("/api/app/schedule")
    public Result addAppointment(@RequestParam("sessionId")Long sessionId){
        try {
            User user = UserInfo.get();
            Appointment appointment = appointmentMapper.selectById(sessionId);
            appointment.setStatus(1);
            appointment.setPatientId(user.getId());
            appointmentMapper.updateById(appointment);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }
}
