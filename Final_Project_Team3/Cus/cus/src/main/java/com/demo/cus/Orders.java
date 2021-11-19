package com.demo.cus;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Orders {
	
	
	private int orderid;
	private int customerid;
	private int vendorid;
	private int menuid ;
	private String walletsource ;
	private int orderquantity ;
	private int orderbillamount ;
	private String orderstatus;
	private String odercommands;
	private Date ORD_DATE;
	
	
	@Id
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getWalletsource() {
		return walletsource;
	}
	public void setWalletsource(String walletsource) {
		this.walletsource = walletsource;
	}
	public int getOrderquantity() {
		return orderquantity;
	}
	public void setOrderquantity(int orderquantity) {
		this.orderquantity = orderquantity;
	}
	public int getOrderbillamount() {
		return orderbillamount;
	}
	public void setOrderbillamount(int orderbillamount) {
		this.orderbillamount = orderbillamount;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getOdercommands() {
		return odercommands;
	}
	public void setOdercommands(String odercommands) {
		this.odercommands = odercommands;
	}
	public Date getORD_DATE() {
		return ORD_DATE;
	}
	public void setORD_DATE(Date oRD_DATE) {
		ORD_DATE = oRD_DATE;
	}
	
	
	
	
}
