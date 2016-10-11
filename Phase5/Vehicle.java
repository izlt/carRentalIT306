package Phase5;

public class Vehicle {
	private String brand;
	private String name;
	private int year;
	private double mileage;
	private boolean availability;
	private String plate;
	private static int vehicleQuantity;
	
	private Customer customer;
	
	public Vehicle() {
		this.setCustomer(new Customer());
		vehicleQuantity++;
	}
	
    public String getBrand() {
        return brand;
    }
	/*
	 Getters and setters of instance variables for information hiding purposes
	 */
    public boolean setBrand(String brand) {
    	if (brand.length()==0) {
    		return false;
    	} else {
        this.brand = brand;
        return true;
    	}
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
    	if (name.length()==0) {
    		return false;
    	} else {
            this.name = name;
            return true;
    	}
    }

    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
    	if (year < 0) {
    		return false;
    	} else {
        this.year = year;
        return true;
    	}
    }

    public double getMileage() {
        return mileage;
    }

    public boolean setMileage(double mileage) {
    	if (mileage < 0) {
    		return false;
    	} else {
    		this.mileage = mileage;
    		return true;
    	}
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getPlate() {
        return plate;
    }

    public boolean setPlate(String plate) {
    	if (plate.length()==0) {
    		return false;
    	} else {
    		this.plate = plate;
    		return true;
    	}
    }
    
    
    public int seatCapacity() {
    	return 0;
    }
    public double rentalPrice(){
    	return 0;
    }
    
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public static int getVehicleQuantity() {
		return vehicleQuantity;
	}

	public static void setVehicleQuantity(int vehicleQuantity) {
		Vehicle.vehicleQuantity = vehicleQuantity;
	}
    public String toString() {
    	return "Brand: " + getBrand()
    			+ "\nName: " + getName()
    			+ "\nYear" + getYear()
    			+ "\nMileage" + getMileage()
    			+ "\nAvailability: "+ (isAvailability() ? "Yes" : "No")
    			+ "\nPlate: " + getPlate();
    }




}
