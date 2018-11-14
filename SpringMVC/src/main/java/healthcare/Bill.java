package healthcare;

public class Bill {
	private String billId;
	private double finalAmount;
	private boolean status; //false:unpaid; true:paid
	private Insurance insurance;
	
	public double getFinalAmount() {
		return this.finalAmount;
	}
	/**
	 * final amount can be only set by calculation 
	 * @return
	 */
	public void setFinalAmount() {
		finalAmount = insurance.calculateFinalAmount(insurance.getAmount());
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
}
