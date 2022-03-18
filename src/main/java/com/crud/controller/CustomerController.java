package com.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Customer;
import com.crud.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	CustomerService cs;
	
	
	public CustomerController(CustomerService cs) {
		super();
		this.cs = cs;
	}

	@PostMapping
	public ResponseEntity<Customer> saveCutomer(@RequestBody Customer cust) {
		
		return new ResponseEntity<Customer>(cs.saveCustomer(cust),HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		
		return cs.getAllCustomer();
		
	}
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable ("id") long id) {
		
		return new ResponseEntity<Customer>(cs.getCustomerById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable ("id") long id,@RequestBody Customer c) {
		
		return new ResponseEntity<Customer>(cs.updateCustomer(c, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable ("id") long id) {
		cs.deleteCustomer(id);
		return new ResponseEntity<String>("customer deleted successfully",HttpStatus.OK);
	}
}
