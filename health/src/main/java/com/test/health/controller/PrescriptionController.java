package com.test.health.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.health.dao.mapper.AppointmentMapper;
import com.test.health.dao.mapper.PrescriptionMapper;
import com.test.health.info.UserInfo;
import com.test.health.model.Appointment;
import com.test.health.model.Prescription;
import com.test.health.model.User;
import com.test.health.vo.PrescriptionVO;
import com.test.health.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


@RestController
public class PrescriptionController {

    @Resource
    private PrescriptionMapper prescriptionMapper;

    @Resource
    private AppointmentMapper appointmentMapper;

    /**
     * add a prescription to the appointment by the doctor
     * @param prescription
     * @return
     */
    @PostMapping("/api/pre/add")
    public Result addPrescription(@RequestBody Prescription prescription){
        try {
            Appointment appointment = appointmentMapper.selectById(prescription.getAppointmentId());
            prescriptionMapper.insert(prescription);
            appointment.setPrescriptionId(prescription.getId());
            appointmentMapper.updateById(appointment);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail();
    }


    /**
     * list all prescription by login patient
     * @return
     */
    @GetMapping("/api/pre/list")
    public Result listPrescriptionByPatient(){
        try {
            User user = UserInfo.get();
            List<Appointment> appointments = appointmentMapper.selectList(new QueryWrapper<Appointment>().eq("patient_id",user.getId()));

            List<PrescriptionVO> voList = new LinkedList<>();
            if(appointments!=null) {
                for (Appointment app : appointments) {
                    Prescription pre = prescriptionMapper.selectOne(new QueryWrapper<Prescription>().eq("appointment_id", app.getId()));
                    if(pre !=null){
                        PrescriptionVO vo = new PrescriptionVO();
                        BeanUtils.copyProperties(pre,vo);
                        vo.setTime(app.getTime());
                        vo.setDoctorName(app.getDoctorName());
                        voList.add(vo);
                    }

                }
            }
            return Result.success(voList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.success();
    }
}
