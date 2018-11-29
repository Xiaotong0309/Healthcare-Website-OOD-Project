package com.test.health.component;

public class DianInsurance implements Insurance {

    public double amount;

    @Override
    public Double calculateDeductAmount() {
        return amount;
    }
}
