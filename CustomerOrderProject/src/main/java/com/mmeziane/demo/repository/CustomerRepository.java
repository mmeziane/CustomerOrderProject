package com.mmeziane.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmeziane.demo.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
