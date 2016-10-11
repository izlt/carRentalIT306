package Phase5;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Implementation {
	public static void main (String [] args) {
		/*
		 Instantiates login authentication class and employee class arrays.
		 To instantiate the individual employee object, the program has to terminate the login object.
		 */
		Login [] login = new Login[100];
		Employee [] employee = new Employee[100];
		Login newUser = null;
		Employee newEmployee = null;
		Object[] options = {"Create a new account", "Use an existing account", "exit"};   

		do {
			/*
			 Login is not done unless there is at least one user.
			 */
			switch (JOptionPane.showOptionDialog(null, "Authentication", 
					"Log-in", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, options, options[0])) {
					case 0: 
						newUser = createAccount(login);
						login[Login.getAccountQuantity()] = newUser;
						newEmployee = createEmployee(login); 
						employee[Employee.getEmployeeQuantity()] = newEmployee;
						break;
					case 1: 
						if (Employee.getEmployeeQuantity() == 0) {
							JOptionPane.showMessageDialog(null, "No Employees!");
							break;
						} else {
							signIn(login, employee);  
						}
						break;
					case 2:
						System.exit(0);
					default: JOptionPane.showMessageDialog(null, "Error");
			}
		} while (true);
	}

	/*
	 The first user is automatically an administrative user.
	 After the first signin, every employee falls onto the regular employee.
	 */
	public static Login createAccount(Login[] login)  {
		Login newLogin = null;
		boolean flag = true;
		if (Login.getAccountQuantity() == 0) {
			JOptionPane.showMessageDialog(null, "You are an administrative employee.");
			newLogin = new Login(flag == true); 
		} else if (Login.getAccountQuantity() > 0) {
			JOptionPane.showMessageDialog(null, "You are a regular employee.");
			newLogin = new Login(flag == false); 			
		}
		try { 
			createUsername(newLogin);  
			createPassword(newLogin);
		} catch (FileNotFoundException e){} catch (IOException e) {}
		return newLogin;

	}
	/*
	 If there is nothing in the username and password files, the program creates ones.
	 */
	public static void createUsername(Login newEmp) throws FileNotFoundException, IOException {
		String employeeUsername = "";
		do {
			employeeUsername = JOptionPane.showInputDialog("Please enter a username.");
			if (!newEmp.setUsername(employeeUsername)) {
				JOptionPane.showMessageDialog(null, "Wrong employee name, please try again");
			}
		} while (!newEmp.setUsername(employeeUsername));
		/*
		 Text file is stored in a source folder.
		 */
		FileOutputStream fstream = new FileOutputStream("./src/Phase5/username.txt", true);
		DataOutputStream outputFile = new DataOutputStream(fstream);
		outputFile.writeUTF(employeeUsername + ", ");
		outputFile.close();
	}


	/*
	 Creates a password and matches with the username recently entered.
	 */
	public static void createPassword(Login newEmp) throws FileNotFoundException, IOException {
		String employeePassword = "";
		do {
			employeePassword = JOptionPane.showInputDialog("Please enter a password.");
			if (!newEmp.setUsername(employeePassword)) {
				JOptionPane.showMessageDialog(null, "Wrong password, please try again");
			}
		} while (!newEmp.setUsername(employeePassword + ", "));
		/*
		 Text file is stored in a source folder.
		 */
		FileOutputStream fstream = new FileOutputStream("./src/Phase5/password.txt", true);
		DataOutputStream outputFile = new DataOutputStream(fstream);
		outputFile.writeUTF(employeePassword + ", ");
		outputFile.close();
	}

	/*
	 Authentication begins, reads username and password files, and matches with the same value.
	 */
	public static void signIn(Login [] newLogin, Employee[] employee) {
		String myUsername = "";
		do {
			myUsername = JOptionPane.showInputDialog("Please enter a username.");
			if (myUsername.length() == 0) {
				JOptionPane.showMessageDialog(null, "Invalid username, please try again.");
			}
		} while (myUsername.length() == 0);
		Scanner validateUsername;
		try {
			validateUsername = new Scanner(new FileInputStream("./src/Phase5/username.txt"));
			while (validateUsername.hasNextLine()) {
				String copy = validateUsername.nextLine();
				if (copy.contains(myUsername + ",")) {

					String myPassword = "";
					do {
						myPassword = JOptionPane.showInputDialog("Please enter a password.");
						if (myPassword.length() == 0) {
							JOptionPane.showMessageDialog(null, "Invalid password, please try again.");
						}
					} while (myPassword.length() == 0);
					Scanner validatePassword;
					try {
						validatePassword = new Scanner(new FileInputStream("./src/Phase5/password.txt"));
						while (validatePassword.hasNextLine()) {
							String passwordCopy = validatePassword.nextLine();
							if (passwordCopy.contains(myPassword + ",")) {
								JOptionPane.showMessageDialog(null, "Welcome");
								work(employee);
								break;
							} else {
								JOptionPane.showMessageDialog(null, "Password not found, try again.");
								break;
							}							
						}
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "File not found");
					}	
				} else {
					JOptionPane.showMessageDialog(null, "Username not found, try again.");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}

	}
	public static Employee createEmployee(Login[] newLogin) {
		Employee newEmployee = new Employee();
		for (int i = 0; i < Login.getAccountQuantity(); i++) {
			newEmployee.setAdminOrNot(newLogin[i+1].isAdminOrNot());
		}
		String name;
		String phone;
		Double eachSales;
		do {
			name = JOptionPane.showInputDialog("Please enter a name of the employee.");
			if (!newEmployee.setName(name)) {
				JOptionPane.showMessageDialog(null, "Error, invalid name");
			}
		} while (!newEmployee.setName(name));


		do {
			phone = JOptionPane.showInputDialog("Please enter a phone number "
					+ "\nFormat: 0001112222");
			if (!newEmployee.setPhone(phone)) {
				JOptionPane.showMessageDialog(null, "Error, invalid phone number");
			}
		} while(!newEmployee.setPhone(phone));
		do {
			try {
				eachSales = Double.parseDouble(JOptionPane.showInputDialog("Please enter each sales"));
			} catch (NumberFormatException e) {
				eachSales = -1.00;
			}
			if (!newEmployee.getSales().setEachSales(eachSales)) {
				JOptionPane.showMessageDialog(null, "Error, invalid each sale");
			}
		} while(!newEmployee.getSales().setEachSales(eachSales));

		return newEmployee;
	}
	/*
	 Interface of the menus differs depending on a role of each employee.
	 An administrative user has more menus than a regular user has.
	 */
	public static void work(Employee [] employee) {
		for (int i = 0; i < Employee.getEmployeeQuantity(); i++) {
			if (employee[i+1].isAdminOrNot()) { //Administrative
				Object[] options = {"Rent a Vehicle", "Return a Vehicle", "Rental Customer Info.", "Sales Info."
						, "Employee Info.", "Vehicle Info.", "Exit"};
				do {
					switch (JOptionPane.showOptionDialog(null, "Please select one of the menus", 
							"Administrative user", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
							null, options, options[0])) {
							case 0:
								JOptionPane.showMessageDialog(null, "Rent a Vehicle");
								rentVehicle(employee[i]);
								break;
							case 1:
								JOptionPane.showMessageDialog(null, "Return a Vehicle");
								returnVehicle(employee, employee[i]);
								break;
							case 2:
								JOptionPane.showMessageDialog(null, "Customer Information");
								printCustomerInformation(employee);
								break;
							case 4:
								JOptionPane.showMessageDialog(null, "Sales Information");
								getSalesInformation(employee);
								break;
							case 5:
								JOptionPane.showMessageDialog(null, "Employee Information");
								getEmployeeInformation(employee);
								break;
							case 6:
								JOptionPane.showMessageDialog(null, "Vehicle Information");
								getVehicleInformation(employee);
								break;
							case 7:
								JOptionPane.showMessageDialog(null, "Now you are exiting this program.");
								System.exit(0);
							default: JOptionPane.showMessageDialog(null, "Error");
					}
				} while(true);
			} else { //Regular
				Object[] options = {"Rent a Vehicle", "Return a Vehicle", "Enter Customer Information"};
				do {
					switch (JOptionPane.showOptionDialog(null, "Please select one of the menus", 
							"Regular user", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
							null, options, options[0])) {
							case 0:
								JOptionPane.showMessageDialog(null, "Enter Customer Information");
								printCustomerInformation(employee);
								break;
							case 1:
								JOptionPane.showMessageDialog(null, "Return a Vehicle");
								returnVehicle(employee, employee[i]);
								break;
							case 2:
								JOptionPane.showMessageDialog(null, "Rent a Vehicle");
								rentVehicle(employee[i]);								
								break;
							case 3:
								JOptionPane.showMessageDialog(null, "Now you are exiting this program.");
								System.exit(0);
					}
				} while(true);
			}
		}
	}
	
	/*
	 Renting a vehicle creates a new car object.
	 */
	public static void rentVehicle(Employee employee) {
		
		String brand;
		do {
			brand = JOptionPane.showInputDialog("Please enter a brand name.");
			if (!employee.getVehicle().setBrand(brand)) {
				JOptionPane.showMessageDialog(null, "Error: invalid brand name!");
			}
		} while(!employee.getVehicle().setBrand(brand));
		double mileage;
		do {
			try {
			mileage = Double.parseDouble(JOptionPane.showInputDialog("Please enter mileage"));
			} catch (NumberFormatException e) {
				mileage = -1;
			}
			if (!employee.getVehicle().setMileage(mileage)) {
				JOptionPane.showMessageDialog(null, "Error: invalid mileage amount!");
			}
		} while(!employee.getVehicle().setMileage(mileage));
		String name;
		do {
			name = JOptionPane.showInputDialog("Please enter a name of the vehicle.");
			if (!employee.getVehicle().setName(name)) {
				JOptionPane.showMessageDialog(null, "Error: invalid name of the vehicle!");
			}
		} while(!employee.getVehicle().setName(name));
		String plate;
		do {
			plate = JOptionPane.showInputDialog("Please enter a plate number.");
			if (!employee.getVehicle().setPlate(plate)) {
				JOptionPane.showMessageDialog(null, "Error: invalid plate number!");
			}
		} while(!employee.getVehicle().setPlate(plate));
		int year;
		do {
			try {
			year = Integer.parseInt(JOptionPane.showInputDialog("Please enter a year of this vehicle."));
			} catch (NumberFormatException e) {
				year = -1;
			}
			if (!employee.getVehicle().setYear(year)) {
				JOptionPane.showMessageDialog(null, "Error: year of the vehicle!");
			}
		} while(!employee.getVehicle().setYear(year));
		employee.getVehicle().setAvailability(JOptionPane.showConfirmDialog(null, "Is this vehicle available?",
				"Availability",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		JOptionPane.showMessageDialog(null, employee.getVehicle().toString());

	}
	/*
	 Returns a vehicle and removes an array of the certain position.
	 */
	public static void returnVehicle(Employee[] employeeList, Employee employee) {
		
	}
	/*
	 Prompts user to enter a customer information and its information is stored within employee class.
	 */
	public static void enterCustomer(Employee employee) {
		Customer.setCustomerQuantity();
		String name;
		do {
			name= JOptionPane.showInputDialog("Please enter a name of the customer.");
			if (!employee.getVehicle().getCustomer().setName(name)) {
				JOptionPane.showMessageDialog(null, "Error, Invalid");
			}
		} while (!employee.getVehicle().getCustomer().setName(name));
		
		String phone;
		do {
			phone = JOptionPane.showInputDialog("Please enter a phone number "
					+ "\nFormat: 0001112222");
			if (!employee.getVehicle().getCustomer().setPhone(phone)) {
				JOptionPane.showMessageDialog(null, "Error, Invalid");
			}
		} while (!employee.getVehicle().getCustomer().setPhone(phone));
		String paymentInfo;
		do {
			paymentInfo = JOptionPane.showInputDialog("Please enter a payment information (Credit, Debit, or Cash)");
			if (!employee.getVehicle().getCustomer().setPaymentInfo(paymentInfo)) {
				JOptionPane.showMessageDialog(null, "Error, Invalid");
			}
		} while (!employee.getVehicle().getCustomer().setPaymentInfo(paymentInfo));
		String address;
		do {
			address = JOptionPane.showInputDialog("Please enter a full address.");
			if (!employee.getVehicle().getCustomer().setAddress(address)) {
				JOptionPane.showMessageDialog(null, "Error, Invalid");
			}
		}while (!employee.getVehicle().getCustomer().setAddress(address));
		String insuranceNumber;
		do {
			insuranceNumber = JOptionPane.showInputDialog("Please enter an insurance number.");
			if (!employee.getVehicle().getCustomer().setInsuranceNumber(insuranceNumber)) {
				JOptionPane.showMessageDialog(null, "Error, Invalid");
			}
		} while (!employee.getVehicle().getCustomer().setInsuranceNumber(insuranceNumber));
		JOptionPane.showMessageDialog(null, employee.getVehicle().getCustomer().toString());
	}
	/*
	 Prints information about the customers.
	 */
	public static void printCustomerInformation(Employee [] employee) {
		if (Customer.getCustomerQuantity() == 0) {
			JOptionPane.showMessageDialog(null, "There is no customer!");
		} else {
			for (int i = 0; i < Customer.getCustomerQuantity(); i++) {
				JOptionPane.showMessageDialog(null, "-------List of Customers-------\n"
						+ (i+1) + ": "+ employee[i+1].getVehicle().getCustomer().getName() + "\n");
				break;
			}			
		}
	}
	/*
	 Prints information about employees and their accomplishments in saels
	 */
	public static void getSalesInformation(Employee [] employee) {
		double total = 0;
		String report = "-------List of employees with sales information-------\n";
		if (Employee.getEmployeeQuantity() == 0) {
			JOptionPane.showMessageDialog(null, "There is no Employee!");
		} else {
			for (int i = 0; i < Employee.getEmployeeQuantity(); i++) {
				total += employee[i+1].getSales().getEachSales();
				report += ((i+1) + " " + employee[i+1].getName() + " Sales: " + employee[i+1].getSales().getEachSales() + "\n"
						);
			}
			report += "\nTotal: " + total;
			JOptionPane.showMessageDialog(null, report);
		}
	}
	/*
	 Prints detailed information of employees.
	 */
	public static void getEmployeeInformation(Employee [] employee) {
		if (Employee.getEmployeeQuantity() == 0) {
			JOptionPane.showMessageDialog(null, "There is no employee!");
		} else {
			for (int i = 0; i < Employee.getEmployeeQuantity(); i++) {
				JOptionPane.showMessageDialog(null, "-------List of Employees-------\n"
						+ (i+1) + ": "+ employee[i+1].getName() + "\n");
			}			
		}
	}
	/*
	 Prints information of the vehicles entered by a user.
	 */
	public static void getVehicleInformation(Employee [] employee) {
		if (Vehicle.getVehicleQuantity() == 0) {
			JOptionPane.showMessageDialog(null, "There is no vehicle!");
		} else {
			for (int i = 0; i < Vehicle.getVehicleQuantity(); i++) {
				JOptionPane.showMessageDialog(null, "-------List of Vehicles-------\n"
						+ (i+1) + " " + employee[i+1].getVehicle().getName() + "\n");
			}			
		}
	}
}
