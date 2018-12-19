package com.test.health.component;


public abstract class Insurance {
	private double amount;
	 /**
	  * Calculate the final amount after deducted by a specific insurance.
	  * Final bill = (amount - deducted amount)
	  * Use Strategy design pattern to implement
	  */
	public double calculateFinalAmount(double amount) {
		return amount;
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}