package com.ilp.tcs.responsemodel;

import com.ilp.tcs.bean.User;

public class CustomerLoginResponse extends StatusModel{
	
	private User data;

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}
	
	

}
