package com.mmeziane.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.mmeziane.demo.model.Customer;


@PreAuthorize("hasRole('ROLE_USER')")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByOrderId(long orderId);
	
	public List<Customer> findByOrderName(String orderName);

}
