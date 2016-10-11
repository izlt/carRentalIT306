package Phase5;

public class Sales implements Cost {
	private double eachSales;
	private static double totalSales;
	
	public Sales() {
		
	}
    public double getEachSales() {
        return eachSales;
    }
	/*
	 Getters and setters of instance variables for information hiding purposes
	 */
    public boolean setEachSales(double eachSales) {
    	if (eachSales < 0) {
    		return false;
    	} else {
            this.eachSales = eachSales;
    		return true;
    	}
    }
    public double getTotalSales() {
    	return totalSales;
    }
    public static void setTotalSales() {
    	totalSales++;
    }
}
