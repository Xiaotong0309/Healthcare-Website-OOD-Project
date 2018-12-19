package com.test.health.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class BillVO {

    private Long appointmentId;

    private Double amount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+18")
    private Date time;

    private String doctorName;

    private Integer status;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
