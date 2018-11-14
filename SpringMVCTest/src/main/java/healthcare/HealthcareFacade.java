package healthcare;

import java.util.ArrayList;

public class HealthcareFacade {
	private ArrayList<Session> session;
	private ArrayList<Appointment> apointment;
	/**
	 * getters and setters
	 * @return
	 */
	public ArrayList<Session> getSession() {
		return session;
	}
	public void setSession(ArrayList<Session> session) {
		this.session = session;
	}
	public ArrayList<Appointment> getApointment() {
		return apointment;
	}
	public void setApointment(ArrayList<Appointment> apointment) {
		this.apointment = apointment;
	}
	/**
	 * singleton
	 */
	private static HealthcareFacade healthcare;
	private HealthcareFacade() {}
	public static HealthcareFacade getInstance(){
        synchronized(HealthcareFacade.class){
            if(healthcare==null){
                return new HealthcareFacade();              
            }
            return healthcare;
        }
    }


	

	
	
}
