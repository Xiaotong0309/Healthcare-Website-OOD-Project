package com.test.health.component;

import com.test.health.*;

public class ISOInsurance extends Insurance{
	public double calculateFinalAmount(double amount) {
		if(amount > 100)
			return amount - (amount-100)*0.8;
		else return amount;
	}
}
