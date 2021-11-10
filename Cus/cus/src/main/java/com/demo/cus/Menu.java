package com.demo.cus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	private int menuid;
	private String menuitem;
	private int menuprice;
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
	public int getMenuprice() {
		return menuprice;
	}
	public void setMenuprice(int menuprice) {
		this.menuprice = menuprice;
	}
	public String getMenuspeciality() {
		return menuspeciality;
	}
	public void setMenuspeciality(String menuspeciality) {
		this.menuspeciality = menuspeciality;
	}
	
	
	
	

}
