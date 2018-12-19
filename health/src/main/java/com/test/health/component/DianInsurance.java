package com.test.health.component;

import com.test.health.*;

public class DianInsurance extends Insurance{

	public double calculateFinalAmount(double amount) {
		return amount*0.5;
	}
}
