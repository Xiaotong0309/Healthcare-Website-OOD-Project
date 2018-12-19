package com.test.health.view;

import com.test.health.model.Appointment;
import com.test.health.model.Patient;


public abstract class View {
	
	private Patient patient;
	
	final public void viewItem() {
		Long id = findUserInfo(this.patient);
		Appointment ap = searchDatabase(id);
		showResult(ap);
		
	};
	public final Long findUserInfo(Patient patient) {
		
		return patient.getId();
	}
	public Appointment searchDatabase(Long id) {
		Appointment appointment = new Appointment();
		
		return appointment;
	}
	final public void showResult(Appointment appointment) {
		System.out.println(appointment);
	}
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
