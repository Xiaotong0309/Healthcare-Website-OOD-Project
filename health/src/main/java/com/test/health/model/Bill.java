package com.test.health.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.test.health.component.Insurance;


public class Bill extends Appointment{
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long appointmentId;

    private Double amount;

    private Integer status;

    private Double price;
    
    private Insurance insurance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", appointmentId=" + appointmentId +
                ", amount=" + amount +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
