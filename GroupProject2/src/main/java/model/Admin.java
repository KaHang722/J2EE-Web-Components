package model;

public class Admin {
	private int adminID;
	private String userName,password;
	
	public Admin(int adminID, String userName, String password) {
		this.adminID = adminID;
		this.userName = userName;
		this.password = password;
	}
	
	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Admin() {
		this.adminID = 0;
		this.userName = "";
		this.password = "";
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", userName=" + userName + ", password=" + password + "]";
	}

	
	
}
