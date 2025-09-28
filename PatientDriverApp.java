package patientprj;

import java.util.Scanner;

public class PatientDriverApp {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Create patient
		Patient patient = new Patient();
		
		System.out.print("Enter first name: ");
		String input = sc.nextLine();
		patient.setFirstName(input);
		
		System.out.print("Enter middle name: ");
		input = sc.nextLine();
		patient.setMiddleName(input);
		
		System.out.print("Enter last name: ");
		input = sc.nextLine();
		patient.setLastName(input);
		
		System.out.print("Enter address: ");
		input = sc.nextLine();
		patient.setAddress(input);
		
		System.out.print("Enter city: ");
		input = sc.nextLine();
		patient.setCity(input);
		
		System.out.print("Enter state: ");
		input = sc.nextLine();
		patient.setState(input);
		
		System.out.print("Enter Zip: ");
		input = sc.nextLine();
		patient.setZip(input);
		
		System.out.print("Enter Phone number: ");
		input = sc.nextLine();
		patient.setPhone(input);
		
		System.out.print("Enter emergency contact name: ");
		input = sc.nextLine();
		patient.setEMSName(input);
		
		System.out.print("Enter emergency contact phone: ");
		input = sc.nextLine();
		patient.setEMSPhone(input);
		
		//Create procedures
		
		Procedure proc1 = new Procedure();
		proc1.setProcName("Blood Test");
		proc1.setProcDate("10/10/2025");
		proc1.setPracticeName("Dr. Johnson");
		proc1.setCharges(250.00);
		
		Procedure proc2 = new Procedure("X-ray", "11/11/2025");
		proc2.setPracticeName("Dr. House");
		proc2.setCharges(500.00);
		
		Procedure proc3 = new Procedure("Kidney Transplant", "12/12/2025", "Dr. Rodriguez", 1500.00);
		
		
		//Display
		System.out.println("Patient:");
		displayPatient(patient);
		
		
		System.out.println();
		displayProcedure(proc1);
		System.out.println();
		displayProcedure(proc2);
		System.out.println();
		displayProcedure(proc3);
		System.out.println();

		
		double total = calculateTotalCharges(proc1, proc2, proc3);
		System.out.printf("Total Charges: $%,.2f,", total);
		
		sc.close();
		
		System.out.println("\n\n\n The program was developed by a Student: Martin Pineda <09/29/25>");
		
		
	}
	
	//Methods
	
	public static void displayPatient(Patient patient) {
		System.out.println(patient.toString());
	}
	
	public static void displayProcedure(Procedure proc) {
		System.out.println(proc.toString());
	}
	
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		return p1.getCharges() + p2.getCharges() + p3.getCharges();
	}
}
