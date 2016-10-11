package Phase5;

/*
 Synchronous invocation of Login and Employee classes
 They contain username and passwords help the Employee class get linked to a Login class.
 */
public class Login {
	private String username;
	private String password;
	private boolean adminOrNot;
	
	private static int accountQuantity;
	public Login() {
		accountQuantity++;
	}
    public Login(boolean flag) {
		this.adminOrNot = flag;
		accountQuantity++;
	}
    public String getUsername() {
        return username;
    }
	/*
	 Getters and setters of instance variables for information hiding purposes
	 */
    public boolean setUsername(String username) {
    	if (username.length() == 0) {
    		return false;
    	} else {
        this.username = username;
        return true;
    	}
    }

    public String getPassword() {

        return password;
    }
	public boolean isAdminOrNot() {
        return adminOrNot;
    }
    public static int getAccountQuantity() {
    	return accountQuantity;
    }
    public boolean setPassword(String password) {
    	if (username.length() == 0) {
    		return false;
    	} else {
    		this.password = password;
    		return true;
    	}
    }
}
