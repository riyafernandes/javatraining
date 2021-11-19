package com.demo.cus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	private int menuid;
	private String menuitem;
	private double menuprice;
	private String menuspeciality;
	
	@Id
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getMenuitem() {
		return menuitem;
	}
	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}
	public double getMenuprice() {
		return menuprice;
	}
	public void setMenuprice(double menuprice) {
		this.menuprice = menuprice;
	}
	public String getMenuspeciality() {
		return menuspeciality;
	}
	public void setMenuspeciality(String menuspeciality) {
		this.menuspeciality = menuspeciality;
	}
	
}
