package com.ilp.tcs.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import com.ilp.tcs.bean.Customer;
import com.ilp.tcs.bean.User;
import com.ilp.tcs.dao.ApplicationDao;
import com.ilp.tcs.responsemodel.CustomerLoginResponse;
import com.ilp.tcs.responsemodel.CustomerRegisterResponse;
import com.ilp.tcs.utils.MessageConstants;

public class ApplicationService {
	public static CustomerRegisterResponse register(Customer customer){
		CustomerRegisterResponse response=new CustomerRegisterResponse();
		ApplicationDao dao=new ApplicationDao();
		try {
			if(!dao.checkCustomer(customer.getSsn())) {
				Customer custrespOBJ;
				long nextCustId=dao.getCustomerId();
				customer.setCust_id(nextCustId);
				if(dao.insertCustomer(customer)>0)
				{  
					custrespOBJ=dao.getCustomer(customer.getCust_id());
					response.setStatus(true);
					response.setStatusCode(HttpServletResponse.SC_OK);
					response.setMessage(MessageConstants.REGISTER_SUCCESS);
					response.setData(custrespOBJ);
				}else {
					response.setStatus(false);
					response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
					response.setMessage(MessageConstants.REGISTER_FAILED);
					
				}
				
				
				
			}
			
			response.setStatus(false);
			response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			response.setMessage(MessageConstants.CUSTOMER_ALREADY_EXIST);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(false);
			response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			response.setMessage(e.getMessage());
		}
		finally {
			return response;
		}
	}
	
	public static CustomerLoginResponse login(long ssn,String password) {
		CustomerLoginResponse customerLoginResponse=new CustomerLoginResponse();
		ApplicationDao dao=new ApplicationDao();
		try {
			User user=dao.login(ssn, password);
			if(user!=null) {
				customerLoginResponse.setStatus(true);
				customerLoginResponse.setMessage(MessageConstants.LOGIN_SUCCESS);
				customerLoginResponse.setStatusCode(HttpServletResponse.SC_OK);
				customerLoginResponse.setData(user);
			}else {
				customerLoginResponse.setStatus(false);
				customerLoginResponse.setMessage(MessageConstants.LOGIN_FAILED);
				customerLoginResponse.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			customerLoginResponse.setStatus(false);
			customerLoginResponse.setMessage(e.getMessage());
			customerLoginResponse.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
		}
		finally {
		return customerLoginResponse;
		}
	}

}
