package com.demo.cus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
	private int customerid;
	private int walletid;
	private int walletamt ;
	private String walletsource ;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	@Id
	public int getWalletid() {
		return walletid;
	}
	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}
	public int getWalletamt() {
		return walletamt;
	}
	public void setWalletamt(int walletamt) {
		this.walletamt = walletamt;
	}
	public String getWalletsource() {
		return walletsource;
	}
	public void setWalletsource(String walletsource) {
		this.walletsource = walletsource;
	}
	
	
	
}
