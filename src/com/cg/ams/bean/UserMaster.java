package com.cg.ams.bean;

public class UserMaster {
	private String userId;
private String username;
private String password;
private String UserType;
private String Employee_no;
public UserMaster() {
	
}

public UserMaster(String userId, String username, String password, String userType,String Employee_no) {
	super();
	this.userId = userId;
	this.username = username;
	this.password = password;
	UserType = userType;
	this.Employee_no=Employee_no;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserType() {
	return UserType;
}

public void setUserType(String userType) {
	UserType = userType;
}

public String getEmployee_no() {
	return Employee_no;
}

public void setEmployee_no(String employee_no) {
	Employee_no = employee_no;
}

@Override
public String toString() {
	return "UserMaster [userId=" + userId + ", username=" + username + ", password=" + password + ", UserType="
			+ UserType + ", Employee_no=" + Employee_no + "]";
}




}
