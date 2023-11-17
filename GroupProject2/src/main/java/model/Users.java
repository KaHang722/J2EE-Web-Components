package model;

public class Users {
	private int userID;
	private String userName,password,cellphone, email, name, address;
	
	public Users(int userID, String userName, String password, String cellphone, String email, String name, String address) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.name = name;
		this.address = address;	
	}
	
	public Users(String userName, String password, String cellphone, String email, String name, String address) {
		this.userName = userName;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.name = name;
		this.address = address;
	}

	public Users() {
		this.userID = 0;
		this.userName = "";
		this.password = "";
		this.cellphone = "";
		this.email = "";
		this.name = "";
		this.address = "";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", userName=" + userName + ", password=" + password + ", cellphone="
				+ cellphone + ", email=" + email + ", name=" + name + ", address=" + address + "]";
	}

	


	
	
	
}
