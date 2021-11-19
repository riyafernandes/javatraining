package com.demo.cus;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WalletService {
	@Autowired
	private WalletRepository repo;
	
	public List<Wallet> showWallet() {
        return repo.findAll();
    }
	
	@Autowired
    private WalletDAO dao;
    
    
  
    public List<Wallet> customerallWallet(int id) {
        return dao.customerWallet(id);
    }
    
    public Wallet displayoneWallet(int id, String source) {
        return dao.onewallet(id,source);
    }
    public String save(Wallet wallet) {
    	wallet.setWalletid(dao.WalletID());
    	repo.save(wallet);
      return "Wallet created";
	
}}
