package com.demo.cus;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> showCustomer() {
        return repo.findAll();
    }
	public Customer get(Integer id) {
        return repo.findById(id).get();
    }
	
	public String save(Customer customer) {
		  customer.setCustomerid(dao.generateCustomerId());
        repo.save(customer);
 MailAlert.sendmail(customer.getCustomeremail()); //you will get mail to emailid u entered in Add customers
 return "Your Details Placed Successfully...";
	}
	@Autowired
    private CustomerDAO dao;
    
    public Customer showonecustomer(String user) {
        return dao.showonecustomer(user);
    }

    
    public String authenticate(String user,String pwd) {
        return dao.authenticate(user, pwd);
    }
}
