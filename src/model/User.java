package model;

public class User {
	private int UserID;
	private String UserName;
	private String UserEmail;
	private String UserPassword;
	private String UserGender;
	private String UserRole;
	
	public User(int userID, String userName, String userEmail, String userPassword, String userGender,
			String userRole) {
		this.UserID = userID;
		this.UserName = userName;
		this.UserEmail = userEmail;
		this.UserPassword = userPassword;
		this.UserGender = userGender;
		this.UserRole = userRole;
	}
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		this.UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		this.UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		this.UserPassword = userPassword;
	}
	public String getUserGender() {
		return UserGender;
	}
	public void setUserGender(String userGender) {
		this.UserGender = userGender;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		this.UserRole = userRole;
	}
	
	
}
