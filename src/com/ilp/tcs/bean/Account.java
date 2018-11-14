package com.ilp.tcs.bean;

public class Account {
	private long acct_id;
	private String acct_type;
	private double acct_balance;
	private String acct_created_date;
	private String acct_status;
	
	
	public Account() {
		
	}
	public long getAcct_id() {
		return acct_id;
	}
	public void setAcct_id(long acct_id) {
		this.acct_id = acct_id;
	}
	public String getAcct_type() {
		return acct_type;
	}
	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}
	public double getAcct_balance() {
		return acct_balance;
	}
	public void setAcct_balance(double acct_balance) {
		this.acct_balance = acct_balance;
	}
	public String getAcct_created_date() {
		return acct_created_date;
	}
	public void setAcct_created_date(String acct_created_date) {
		this.acct_created_date = acct_created_date;
	}
	public String getAcct_status() {
		return acct_status;
	}
	public void setAcct_status(String acct_status) {
		this.acct_status = acct_status;
	}
	
	
	

}
