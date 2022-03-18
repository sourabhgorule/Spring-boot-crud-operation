package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.exception.ResourceNotFound;
import com.crud.model.Customer;
import com.crud.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepo cr;
	
	
	public CustomerServiceImpl(CustomerRepo cr) {
		super();
		this.cr = cr;
	}

	@Override
	public Customer saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		return cr.save(c);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return cr.findById(id).orElseThrow(()->new ResourceNotFound("Customer", "id", id));
		
	}

	@Override
	public Customer updateCustomer(Customer c, long id) {
		
		Customer existing_customer=cr.findById(id).orElseThrow(
				()->new ResourceNotFound("customer", "id", id));

		existing_customer.setAddress(c.getAddress());
		existing_customer.setName(c.getName());
		
		cr.save(existing_customer);
		
		
		
		return existing_customer;
	}

	@Override
	public void deleteCustomer(long id) {
		
		cr.findById(id).orElseThrow(()->new ResourceNotFound("Customer", "id", id));
		
		cr.deleteById(id);
		
	}

}
