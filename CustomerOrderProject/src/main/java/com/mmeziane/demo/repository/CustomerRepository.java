package com.mmeziane.demo.repository;

/*
 * Our CustomerRepository interface that works with Customer entities:
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.mmeziane.demo.model.Customer;

/*
 * Only users who have a role ROLE_USER can invoke it
 */
@PreAuthorize("hasRole('ROLE_USER')")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByOrderId(long orderId);
	
	public List<Customer> findByOrderName(String orderName);

}
