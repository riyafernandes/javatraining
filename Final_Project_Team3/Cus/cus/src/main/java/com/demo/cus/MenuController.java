package com.demo.cus;

import java.util.List;


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



import java.util.NoSuchElementException;

@RestController
public class MenuController {
	@Autowired
	 private MenuService mservice;
	 
	
		@CrossOrigin(origins="http://localhost:4200")
	    @RequestMapping(value="/showmenu")
	    public List<Menu> list() {
	        return mservice.showmenu();
	        
	    }
		
		@CrossOrigin(origins="http://localhost:4200")
	    @GetMapping("/menu/{id}")
	    public ResponseEntity<Menu> get(@PathVariable Integer id) {
	        try {
	            Menu menu = mservice.get(id);
	            return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
	        }      }
		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping("/addmenu")
	    public void add(@RequestBody Menu menu) {
	      mservice.save(menu);
	    }

}
