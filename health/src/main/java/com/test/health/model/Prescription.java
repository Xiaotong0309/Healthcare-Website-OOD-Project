package com.test.health.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


public class Prescription extends Appointment{
    @TableId(type = IdType.AUTO)
    private Long id;

    private String diagnosis;

    private String medicine;

    private Long appointmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", diagnosis='" + diagnosis + '\'' +
                ", medicine='" + medicine + '\'' +
                ", appointmentId=" + appointmentId +
                '}';
    }
}
