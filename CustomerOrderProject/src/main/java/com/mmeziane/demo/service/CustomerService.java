package com.mmeziane.demo.service;

/*
 * CustomerService class which works between REST controller and Data layer:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmeziane.demo.model.Customer;
import com.mmeziane.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	/** 
	 * The @Autowired annotation injects CustomerRepository implicitly.
	 */
	@Autowired
	private CustomerRepository customerRepository;
	

	public CustomerService() {
		
	}
	
	public List<Customer> getAllOrders(long orderId){
		
		List<Customer> customers = new ArrayList<>();
		customerRepository.findByOrderId(orderId);
		
		return customers;
		
	}
	
	public Optional<Customer> getCustomer(long id) {
		
		return customerRepository.findById(id);
		
		
	}
	
	public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);

        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers) {
            Customer cust = new Customer();
            BeanUtils.copyProperties(customer, cust);
            customerList.add(cust);
        }

        return customerList;
    }
	
	public Customer getCustomer(Long id) {

		Optional<Customer>  customer = customerRepository.findById(id);
        Customer customerData = new Customer();
        BeanUtils.copyProperties(customer.get(), customerData);
        return customerData;
    }
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCourse(Customer customer) {
		customerRepository.save(customer);
		System.out.println("Updated course.id = " + customer.getId() + " with Firstname = " + customer.getFirstName() + " and Lastname = " + customer.getLastName()  );
	}
	
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}
	
	

}
