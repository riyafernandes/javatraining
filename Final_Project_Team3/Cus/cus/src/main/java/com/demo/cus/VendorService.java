package com.demo.cus;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class VendorService {

	@Autowired
	private VendorRepository repo;
	
	public List<Vendor> showVendor() {
        return repo.findAll();
    }
	public Vendor get(Integer id) {
        return repo.findById(id).get();
    }
	
	public String save(Vendor vendor) {
  		vendor.setVendorid(dao.generateVendorId());
          repo.save(vendor);
          String v=vendor.getVendoremail();
          MailAlert.sendmail(v);//you willget mail to emailid u entered
          return "Your Details Placed Successfully...";
	}
	
	@Autowired
    private VendorDAO dao;
    
    public String authenticate(String user,String pwd) {
        return dao.authenticate(user, pwd);
    }
	
    public Vendor showonevendor(String user) {
		// TODO Auto-generated method stub
		 return dao.showonevendor(user);
	}
}
