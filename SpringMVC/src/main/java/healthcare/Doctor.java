package healthcare;

public class Doctor {
	private String id;
	private String name;
	private String title;
	private String phone;
	private String password;
	
	public void addPrescription(String appointmentId, String diagnoisis, String medicine) {
		/**
		 * interact with database
		 */
	}
	public void addSesion(String docotorId, String sessionId) {
		/**
		 * interact with database
		 */
	}
	public void deleteSession(String docotorId, String sessionId) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
