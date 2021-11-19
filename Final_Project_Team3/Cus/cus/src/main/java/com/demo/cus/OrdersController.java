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
public class OrdersController {
	 @Autowired
	 private OrdersService service;
	 
	 
		@CrossOrigin(origins="http://localhost:4200")
	    @RequestMapping(value="/showorders")
	    public List<Orders> list() {
	        return service.showOrders();
	        
	    }
		
		@CrossOrigin(origins="http://localhost:4200")
	    @GetMapping("/orders/{id}")
	    public ResponseEntity<Orders> get(@PathVariable Integer id) {
	        try {
	            Orders orders = service.get(id);
	            return new ResponseEntity<Orders>(orders, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
	        }      }	
		 @CrossOrigin(origins="http://localhost:4200")
		 @RequestMapping("/vendorsorder/{id}")
		    public List<Orders> vendorordershere(@PathVariable int id) {
		        return service.vendorallOrders(id);  //
		    }
		 @CrossOrigin(origins="http://localhost:4200")
		 @RequestMapping("/vendorspendingorder/{id}")
		    public List<Orders> vendorpendingordershere(@PathVariable int id) {
		        return service.vendorallPendingOrders(id); //
		    }
		 @CrossOrigin(origins="http://localhost:4200")
		 @RequestMapping("/customersorder/{id}")
		    public List<Orders> customerordershere(@PathVariable int id) {
		        return service.customerallOrders(id);
		    }
		 @CrossOrigin(origins="http://localhost:4200")
		 @RequestMapping("/customerspendingorder/{id}")
		    public List<Orders> customerpendingordershere(@PathVariable int id) {
		        return service.customerallPendingOrders(id);
		    }
		 @CrossOrigin(origins="http://localhost:4200")
		 @PostMapping("/placeOrder")
		    public String add(@RequestBody Orders orders) {
		        return service.placeOrder(orders);
		    }
		 @CrossOrigin(origins="http://localhost:4200")

		 @PostMapping("/acceptOrRejectOrder/{ordId}/{venId}/{status}")
			public String acceptOrReject(@PathVariable int ordId,@PathVariable int venId, 
					@PathVariable String status) {
				return service.acceptOrRejectOrder(ordId, venId, status);
			}
}
