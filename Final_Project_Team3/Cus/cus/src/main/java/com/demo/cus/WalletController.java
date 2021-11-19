package com.demo.cus;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
	@Autowired
	 private WalletService service;
	 
	 
		@CrossOrigin(origins="http://localhost:4200")
	    @RequestMapping(value="/showwallet")
	    public List<Wallet> list() {
	        return service.showWallet();
	        
	    }
		

		 @CrossOrigin(origins = "http://localhost:4200")
		 @RequestMapping("/customerswallet/{id}")
		    public List<Wallet> customerwallethere(@PathVariable int id ) {
		        return service.customerallWallet(id);
 }

		 @CrossOrigin(origins = "http://localhost:4200")
		 @RequestMapping("/customersonewallet/{id}/{source}")
		    public Wallet customeronewallethere(@PathVariable int id, @PathVariable String source) {
		        return service.displayoneWallet(id,source);
		    }
		 @CrossOrigin(origins="http://localhost:4200")
			@PostMapping("/addwallet")
		    public void add(@RequestBody Wallet wallet) {
		      service.save(wallet);
		    }
}
