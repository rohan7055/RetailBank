create table customer_groupB
(
	SSN number(9) unique ,
	cust_id number(9) primary key,
	cust_name varchar2(80),
	cust_addr varchar2(255),
	cust_age number(9) check (cust_age >= 18),
	cust_city varchar2(25),
	cust_state varchar2(15),
	cust_status varchar2(15) check (cust_status in ('active','inactive')),
	cust_create_date timestamp,
	cust_last_updated timestamp,
	constraint valid_ssn check (REGEXP_LIKE(SSN,'^\d{9}$'))
);

create sequence custId_seq start with 300000001 MAXVALUE 999999999 increment by 1

select * from CUSTOMER_GROUPB;

insert into CUSTOMER_GROUPB values (123456789,custId_seq.nextval,'Rishabh','Rajasthan',19,'Deoli','Rajasthan','active',
CURRENT_TIMESTAMP,CURRENT_TIMESTAMP
);

create table account_groupB
(
	acct_id number(9) primary key,
	cust_id number(9),
	acct_type varchar2(2) check(acct_type in ('S','C')), 
	acct_balance number(11,2),
	acct_created_date timestamp,
	acct_status varchar2(15) check(acct_status in ('active','inactive')),
	foreign key(cust_id) references customer_groupB(cust_id)		
);

select * from account_GROUPB;

create sequence acctId_seq start with 500000001 MAXVALUE 999999999 increment by 1

insert into account_groupB values (acctId_seq.nextval,300000001,'S',23000,CURRENT_TIMESTAMP,'active')

create table userStore_groupB
(
	SSN number(9),
	password varchar2(255),
	cust_id number(9),
	user_last_login timestamp,
	foreign key(SSN) references customer_groupB(SSN),
	foreign key(cust_id) references customer_groupB(cust_id)
);

truncate table USERSTORE_GROUPB;
update USERSTORE_GROUPB set password='D6B0AB7F1C8AB8F514DB9A6D85DE160A' where ssn=300000001;
insert into userStore_groupB values (123456789,'5f4dcc3b5aa765d61d8327deb882cf99',300000001,CURRENT_TIMESTAMP)
insert into userStore_groupB values (705574316,'D6B0AB7F1C8AB8F514DB9A6D85DE160A',300000006,CURRENT_TIMESTAMP)


select * from userStore_groupB;

