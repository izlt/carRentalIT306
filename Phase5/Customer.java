package Phase5;

public class Customer {
	public static final int MAXIMUM_PHONE_LENGTH = 9;
	private String name;
	private String phone;
	private String address;
	private String licenseNumber;
	private String insuranceNumber;
	private String paymentInfo;
	private static int customerQuantity;
	
	public Customer() {
	}
	/*
	 Getters and setters of instance variables for information hiding purposes
	 */
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

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
    	if (address.length()==0) {
    		return false;
    	} else {
    		this.address = address;
    		return true;
    	}
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public boolean setLicenseNumber(String licenseNumber) {
    	if (licenseNumber.length() == 0) {
    		return false;
    	} else {
        this.licenseNumber = licenseNumber;
        return true;
    	} 
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public boolean setInsuranceNumber(String insuranceNumber) {
    	if (insuranceNumber.length() == 0) {
    		return false;
    	} else {
    		this.insuranceNumber = insuranceNumber;
    		return true;
    	}
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public boolean setPaymentInfo(String paymentInfo) {
    	if (paymentInfo.length()==0) {
    		return false;
    	} else {
    		this.paymentInfo = paymentInfo;
    		return true;
    	}
    }
	public static int getCustomerQuantity() {
		return customerQuantity;
	}
	public static void setCustomerQuantity() {
		customerQuantity++;
	}
    public String toString() {
    	return "Name: " + getName() + "\nAddress:: " + getAddress()
    			+ "\nPhone number: " + getPhone() + "\nPayment Method: " + getPaymentInfo()
    			+ "\nInsurance Number:" +getInsuranceNumber() + "\nLicense Number: " + getLicenseNumber();
    }

}
