package patientprj;

public class Procedure {
	
	//Attributes
	private String procName;
	private String procDate;
	private String practiceName;
	private double charges;
	
	
	//Default Constructor
	public Procedure() {}
	
	//Name and date constructor
	
	public Procedure(String proName, String proDate) {
		procName = proName;
		procDate = proDate;
	}
	
	//All param constructor
	
	public Procedure(String proName, String proDate, String practicioner, double charge) {
		procName = proName;
		procDate = proDate;
		practiceName = practicioner;
		charges = charge;
		
	}
	
	
	
	//Getters
	public String getProcName() {
		return procName;
	}
	public String getprocDate() {
		return procDate;
	}
	public String practiceName() {
		return practiceName;
	}
	public double getCharges() {
		return charges;
	}
	
	
	//Setters
	
	public void setProcName(String proName) {
		procName = proName;
	}
	public void setProcDate(String proDate) {
		procDate = proDate;
	}
	public void setPracticeName(String practicioner) {
		practiceName = practicioner;
	}
	
	public void setCharges(double charge) {
		charges = charge;
	}
	
	
	@Override
	
	public String toString() {
		return "\tProcedure Name: " + procName + "\n\tProcedure Date: " + procDate + 
				"\n\tPracticioner Name: " + practiceName + "\n\tCharges: " + charges;
	}
}
