package patientprj;

public class Patient {
	
	
	//Attributes
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String emsName;
	private String emsPhone;
	
	// Default Constructor
	public Patient() {}
	
	
	//Name
	public Patient(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
	}
	
	//All params
	public Patient(String fName, String mName, String lName, 
			String add, String cit, String stat, String zipC, String cell, 
			String emergName, String emergPhone) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
		address = add;
		city = cit;
		state = stat;
		zip = zipC;
		phone = cell;
		emsName = emergName;
		emsPhone = emergPhone;
		
	}
	
	//Getters
	
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName; 
	}
    public String getLastName() {
    	return lastName;
    }
    public String getAddress() {
    	return address; 
    }
    public String getCity() {
    	return city;
    }
    public String getState() {
    	return state;
    }
    public String getZip() {
    	return zip;
    }
    public String getPhone() {
    	return phone;
    }
    public String getEMSName() {
    	return emsName;
    	}
    public String getEMSPhone() {
    	return emsPhone; 
    }
    
    
    //Setters
    
    public void setFirstName(String fName) {
    	firstName = fName;
    }
    public void setMiddleName(String mName) {
    	middleName = mName;
    }
    public void setLastName(String lName) {
    	lastName = lName;
    }
    public void setAddress(String add) {
    	address = add;
    }
    public void setCity(String cit) {
    	city = cit;
    }
    public void setState(String stat) {
    	state = stat;
    }
    public void setZip(String zipC) {
    	zip = zipC;
    }
    public void setPhone(String cell) {
    	phone = cell;
    }
    public void setEMSName(String emergName) {
    	emsName = emergName;
    }
    public void setEMSPhone(String emergPhone) {
    	emsPhone = emergPhone;
    }
    
    //Methods
    
    public String buildFullName() {
    	return firstName + " " + middleName + " " + lastName;
    }
    
    public String buildAddress() {
    	return address + " " + city + " " + state + " " + zip;
    }
    
    public String buildEmergencyContact() {
    	return emsName + " " + emsPhone;
    }
    
    
    @Override
    
    public String toString() {
    	return "  Name: " + buildFullName() + "\n  Address: " + buildAddress() + "\n  Phone: " + phone + 
    			"\n  Emergency Contact= " + buildEmergencyContact();
    }
		
}
