package com.ilp.tcs.helpers;

public class QueryHelper {
	
	public static final String CHECK_CUSTOMER="select * from customer_groupB where ssn=?";
	public static final String GET_CUSTOMER_BY_ID="select * from customer_groupB where cust_id=?";
	public static final String INSERT_CUSTOMER="insert into CUSTOMER_GROUPB values (?,?,?,?,?,?,?,'active',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
    public static final String LOGIN_QUERY="select * from USERSTORE_GROUPB where ssn=? and password=?";
}
