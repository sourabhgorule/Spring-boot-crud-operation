package com.crud.service;

import java.util.List;

import com.crud.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer c);
	
	List<Customer> getAllCustomer();
	
	Customer getCustomerById(long id);
	
	Customer updateCustomer(Customer c,long id);
	
	void deleteCustomer(long id);
	
}
