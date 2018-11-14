package com.ilp.tcs.bean;

public class User {
   private long ssn;
   private String password;
   private long cust_id;
   private String user_last_login;
   
   
public User() {
	
}
public long getSsn() {
	return ssn;
}
public void setSsn(long ssn) {
	this.ssn = ssn;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getCust_id() {
	return cust_id;
}
public void setCust_id(long cust_id) {
	this.cust_id = cust_id;
}
public String getUser_last_login() {
	return user_last_login;
}
public void setUser_last_login(String user_last_login) {
	this.user_last_login = user_last_login;
}
   
   
}
