package Phase5;

/*
 Employee class stores three classes, sales, vehicles, and customers. They are invoked every time,
 the class reserves array spaces for three classes and they are free to be invoked when a user is 
 intended to do so.
 
 */
public class Employee {
	public static final int MAXIMUM_PHONE_LENGTH = 10;
	private boolean adminOrNot;
	private String name;
	private String phone;
	private int rentalQuantity;
	
	private Sales sales;
	private Vehicle vehicle;
	private Customer customer;
	
	private static int employeeQuantity;
	/*
	 Constructor of Employee Class
	 */
	public Employee() {
		employeeQuantity++;
		this.sales = new Sales();
		this.setVehicle(new Vehicle());
		this.setCustomer(customer);
		
	}

    public Employee(boolean flag) {
		this.adminOrNot = flag;
		this.sales = new Sales();
	}
	/*
	 Getters and setters of instance variables for information hiding purposes
	 */
	public boolean isAdminOrNot() {
        return adminOrNot;
    }

    public void setAdminOrNot(boolean adminOrNot) {
        this.adminOrNot = adminOrNot;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
    	if (name.length() == 0) {
    		return false;
    	} else {
        this.name = name;
        return true;
    	}
    }

    public String getPhone() {
        return phone;
    }

	public boolean setPhone(String phone) {
		boolean isNumber = false;
		for (int i = 0; i < phone.length(); i++){
			char phoneVerification = phone.charAt(i);
			if (Character.isDigit(phoneVerification) == true) {
				isNumber = true;
			} else {
				isNumber = false;
			}
		}
		if (phone.length() == MAXIMUM_PHONE_LENGTH && isNumber)
		{
			this.phone = phone;
			return true;
		} else {
			return false;
		}
	}

    public int getRentalQuantity() {
        return rentalQuantity;
    }

    public void setRentalQuantity(int rentalQuantity) {
        this.rentalQuantity = rentalQuantity;
    }

    
    
    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public static int getEmployeeQuantity() {
        return employeeQuantity;
    }
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/*
	toString prints detail of one customer.
	 */
    public String toString() {
    	String result = "";
    	result = "Name: " + getName() + "\nSales: " + getSales().getEachSales()
    			+ "\nPhone number: " + getPhone() + "\n";
    	return result;
    }

}
