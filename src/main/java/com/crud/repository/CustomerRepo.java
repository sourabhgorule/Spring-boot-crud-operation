package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.crud.model.Customer;

@Component
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>
{

}
