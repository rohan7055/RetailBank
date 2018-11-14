package com.ilp.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ilp.tcs.bean.Customer;
import com.ilp.tcs.bean.User;
import com.ilp.tcs.helpers.QueryHelper;
import com.ilp.tcs.utils.DatabaseUtil;
import com.ilp.tcs.utils.MD5;

public class ApplicationDao {
	
	//This Function Checks for the SSN id exist the database
	public boolean checkCustomer(long ssn) throws SQLException {
		boolean found=false;
		Connection conn=DatabaseUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(QueryHelper.CHECK_CUSTOMER);
		ps.setLong(1, ssn);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			found=true;
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(conn);
		return found;
	}
	
	public Customer getCustomer(long cust_id) throws SQLException {
		Customer customer=null;
		Connection conn=DatabaseUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(QueryHelper.GET_CUSTOMER_BY_ID);
		ps.setLong(1, cust_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			customer=new Customer();
			customer.setSsn(rs.getLong(1));
			customer.setCust_id(rs.getLong(2));
			customer.setCust_name(rs.getString(3));
			customer.setCust_addr(rs.getString(4));
			customer.setCust_age(rs.getInt(5));
			customer.setCust_city(rs.getString(6));
			customer.setCust_state(rs.getString(7));
			customer.setCust_status(rs.getString(8));
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(conn);
		
		return customer;
	}
	
	public int insertCustomer(Customer customer) throws SQLException {
		//String sql1="insert into CUSTOMER_GROUPB values (123456789,custId_seq.nextval,'Rishabh','Rajasthan',19,'Deoli','Rajasthan','active',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
        int updated=0;
		String sql="insert into CUSTOMER_GROUPB values (?,?,?,?,?,?,?,'active',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
		Connection conn=DatabaseUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(QueryHelper.INSERT_CUSTOMER);
		ps.setLong(1, customer.getSsn());
		ps.setLong(2, customer.getCust_id());
		ps.setString(3, customer.getCust_name());
		ps.setString(4, customer.getCust_addr());
		ps.setInt(5, customer.getCust_age());
		ps.setString(6, customer.getCust_city());
		ps.setString(7, customer.getCust_state());
		updated=ps.executeUpdate();
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(conn);
		return updated;
	}
	
	public long getCustomerId() throws SQLException {
		long seqId=0;
		String sql="select custId_seq.nextval from dual";
		Connection conn=DatabaseUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			seqId=rs.getLong(1);
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(conn);
		return seqId;
		
	}
	
	public User login(long ssn,String password) throws SQLException {
		User user=null;
		String sql="select * from USERSTORE_GROUPB where ssn=? and password=?";
		Connection conn=DatabaseUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(QueryHelper.LOGIN_QUERY);
		ps.setLong(1, ssn);
		ps.setString(2, MD5.passwordToMD5(password).toUpperCase());
		ResultSet rs=ps.executeQuery();
		
        while(rs.next()) {
        	user=new User();
        	user.setSsn(rs.getLong(1));
        	user.setCust_id(rs.getLong(3));
        	
        }
        DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(conn);
	    return user;
	}
	

}
