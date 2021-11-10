package com.demo.cus;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
	 @Autowired
	 private VendorService service;
	 
	
		@CrossOrigin(origins="http://localhost:4200")
	    @RequestMapping(value="/showvendor")
	    public List<Vendor> list() {
	        return service.showVendor();
	        
	    }
		@CrossOrigin(origins="http://localhost:4200")
	    @GetMapping("/vendor/{id}")
	    public ResponseEntity<Vendor> get(@PathVariable Integer id) {
	        try {
	            Vendor vendor = service.get(id);
	            return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
	        }      
	    }
		
		
}
