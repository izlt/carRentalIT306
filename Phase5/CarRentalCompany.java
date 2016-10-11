package Phase5;

public class CarRentalCompany {
	Employee [] employee;
	private int employeeQuantity;
	Customer [] customer;
	private int customerQuantity;
	Vehicle [] vehicle;
	private int vehicleQuantity;
	
	public CarRentalCompany() {
		this.employee = new Employee[100];
		this.customer = new Customer[30];
		this.vehicle = new Vehicle[50];
	}
	public CarRentalCompany(Employee [] employee, Customer [] customer, Vehicle [] vehicle) {
		for (int i = 0; i < employee.length; i++) {
			this.employee[i] = employee[i];
		}
		for (int i = 0; i < customer.length; i++) {
			this.customer[i] = customer[i];
		}
		for (int i = 0; i < vehicle.length; i++) {
			this.vehicle[i] = vehicle[i];
		}
	}
	public int getEmployeeQuantity() {
		return employeeQuantity;
	}
	public int getCustomerQuantity() {
		return customerQuantity;
	}
	public int getVehicleQuantity() {
		return vehicleQuantity;
	}
    public Employee getEmployee(int position) {
    	return this.employee[position];
    }

    public int setEmployee() {
    	if (this.employeeQuantity < employee.length) {
    		this.employee[employeeQuantity++] = new Employee();
    		return employeeQuantity - 1;
    	} else {
    		return -1;
    	}
    }

    public Customer getCustomer(int position) {
    	return this.customer[position];
    }

    public int setCustomer(Customer[] customer) {
    	if (this.customerQuantity < customer.length) {
    		this.customer[customerQuantity++] = new Customer();
    		return customerQuantity - 1;
    	} else {
    		return -1;
    	}
    }

    public Vehicle getVehicle(int position) {
        return this.vehicle[position];
    }

    public int setVehicle(Vehicle[] vehicle) {
    	if (this.vehicleQuantity < vehicle.length) {
    		this.vehicle[vehicleQuantity++] = new Vehicle();
    		return vehicleQuantity - 1;
    	} else {
    		return -1;
    	}
    }
}
