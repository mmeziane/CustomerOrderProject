package com.mmeziane.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.mmeziane.demo.model.Order;

/*
 * Only users who have a role ROLE_USER can invoke it
 */
@PreAuthorize("hasRole('ROLE_USER')")
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
