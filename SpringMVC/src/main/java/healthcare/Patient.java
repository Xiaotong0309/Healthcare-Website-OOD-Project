package healthcare;

import java.util.ArrayList;

public class Patient {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String password;
	
	/**
	 * Get available sessions by docotr's name
	 * @param name
	 * @return
	 */
	public ArrayList<Session> viewSessions(String name) {
		ArrayList<Session> sessions = new ArrayList<Session>();
		/**
		 * interact with database
		 */
		return sessions;
	}
	/**
	 * Get all available sessions
	 * @return
	 */
	public ArrayList<Session> viewAllSessions() {
		ArrayList<Session> sessions = new ArrayList<Session>();
		/**
		 * interact with database
		 */
		return sessions;
	}
	/**
	 * @param PatientId
	 * @return
	 */
	public ArrayList<Appointment> viewAppointment(String PatientId) {
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		/**
		 * interact with database
		 */
		return appointments;
	}
	public void scheduleAppointment(String sessionId, String patientId) {
		Appointment appointment = new Appointment();
		appointment.setSessionId(sessionId);
		appointment.setPatientId(patientId);
		
		/**
		 * session' status to false
		 * interact with database
		 */
	}
	/**
	 * doctor, patient, admin cancel appointment
	 * @param appointmentId
	 */
	public void cancelAppointment(String appointmentId) {
		
		/**
		 * session' status to true
		 * interact with database
		 */
	}
	public Bill viewBill(String appointmentId) {
		Bill bill = new Bill();
		/**
		 * interact with database
		 */
		return bill;
	}
	public void payBill(String appointmentId) {
		/**
		 * interact with database
		 */
	}
	public Prescription viewPrescription(String appointmentId) {
		Prescription pres = new Prescription();
		/**
		 * interact with database
		 */
		return pres;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
