package model;

public class Friends {
	private int friendID,age;
	private String friendName,emailAddress,favoriteColor;
	
	public Friends(int friendID, int age, String friendName, String emailAddress, String favoriteColor) {
		this.friendID = friendID;
		this.age = age;
		this.friendName = friendName;
		this.emailAddress = emailAddress;
		this.favoriteColor = favoriteColor;
	}
	
	public Friends(int age, String friendName, String emailAddress, String favoriteColor) {
		this.age = age;
		this.friendName = friendName;
		this.emailAddress = emailAddress;
		this.favoriteColor = favoriteColor;
	}

	public Friends() {
		this.friendID = 0;
		this.age = 0;
		this.friendName = "";
		this.emailAddress = "";
		this.favoriteColor = "";
	}

	public int getFriendID() {
		return friendID;
	}

	public void setFriendID(int friendID) {
		this.friendID = friendID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

	@Override
	public String toString() {
		return "Friends [friendID=" + friendID + ", age=" + age + ", friendName=" + friendName + ", emailAddress="
				+ emailAddress + ", favoriteColor=" + favoriteColor + "]";
	}
	
	
}
