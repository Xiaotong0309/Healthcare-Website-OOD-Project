package healthcare;

public class Admin {
	private String id;
	private String password;
	
	public Patient viewPatients(String name) {
		Patient patient = new Patient();
		/**
		 * interact with database
		 */
		return patient;
	}
	public void addDoctor(String name, String phone, String title) {
		Doctor doctor = new Doctor();
		doctor.setName(name);
		doctor.setPhone(phone);
		doctor.setTitle(title);
		
		/**
		 * interact with database
		 */
	}
	public void deleteDoctor(String id) {
		
		/**
		 * interact with database
		 */
	}
	public void addBill(String appointmentId, double amount, String insurance) {
		/**
		 * interact with database
		 */
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
