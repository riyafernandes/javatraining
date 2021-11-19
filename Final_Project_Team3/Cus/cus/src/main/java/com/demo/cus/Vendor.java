package com.demo.cus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {
	private int vendorid;
	private String vendorname;
	private String vendorphonenumber ;
	private String vendorusername ;
	private String vendorpassword ;
	private String vendoremail ;
	
	@Id
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getVendorphonenumber() {
		return vendorphonenumber;
	}
	public void setVendorphonenumber(String vendorphonenumber) {
		this.vendorphonenumber = vendorphonenumber;
	}
	public String getVendorusername() {
		return vendorusername;
	}
	public void setVendorusername(String vendorusername) {
		this.vendorusername = vendorusername;
	}
	public String getVendorpassword() {
		return vendorpassword;
	}
	public void setVendorpassword(String vendorpassword) {
		this.vendorpassword = vendorpassword;
	}
	public String getVendoremail() {
		return vendoremail;
	}
	public void setVendoremail(String vendoremail) {
		this.vendoremail = vendoremail;
	}
	
	
}
