package healthcare;

public class Prescription {
	private String PrescId;
	private String diagnosis;
	private String medicine;
	public String getPrescId() {
		return PrescId;
	}
	public void setPrescId(String prescId) {
		PrescId = prescId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
}
