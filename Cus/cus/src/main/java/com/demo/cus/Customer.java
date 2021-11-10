package com.demo.cus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer{
	private int customerid;
	private String customername;
	private String customerphonenumber ;
	private String customerusername ;
	private String customerpassword ;
	private String customeremail ;
	
	
	public String getCustomername() {
		return customername;
	}
	@Id
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public String getCustomerphonenumber() {
		return customerphonenumber;
	}
	public void setCustomerphonenumber(String customerphonenumber) {
		this.customerphonenumber = customerphonenumber;
	}
	public String getCustomerusername() {
		return customerusername;
	}
	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}
	public String getCustomerpassword() {
		return customerpassword;
	}
	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	

}
