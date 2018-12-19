package com.test.health.model;

public class UserFactory {
	private int type;//0:Admin, 1:Doctor, 2:Patient

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public User FactoryMethod() {
		User o = new User();
		if(type == 0) {
			User u = new Admin();
			return u;
			
		}
		else if(type == 1) {
			User u = new Doctor();
			return u;
			
		}
		else if(type == 2) {
			User u = new Patient();
			return u;
			
		}
		return o;
		
	}
}
