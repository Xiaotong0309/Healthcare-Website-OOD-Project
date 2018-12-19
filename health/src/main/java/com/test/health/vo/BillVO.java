package com.test.health.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.test.health.*;
import com.test.health.component.Insurance;

import java.util.Date;

public class BillVO extends AppointmentVO{

    private Long appointmentId;

    private Double amount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+18")
    private Date time;

    private String doctorName;

    private Integer status;
    
    private Insurance insurance;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setAmount() {
		amount = this.insurance.calculateFinalAmount(this.insurance.getAmount());
	}

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
