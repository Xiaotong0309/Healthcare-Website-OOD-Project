package com.test.health.component;


public class GoldenInsurance implements Insurance {

    public double amount;

    @Override
    public Double calculateDeductAmount() {
        return amount*0.5;
    }
}
