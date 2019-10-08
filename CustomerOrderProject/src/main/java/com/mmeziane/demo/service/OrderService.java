package com.mmeziane.demo.service;

/*
 * OrderService class which works between REST controller and Data layer:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmeziane.demo.model.Order;
import com.mmeziane.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	/** 
	 * The @Autowired annotation injects OrderRepository implicitly.
	 */
	@Autowired
	private OrderRepository orderRepository;

	public OrderService() {
		
	}
	
	public List<Order> getAllOrders() {
		
		List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}
	
	public Order getOrder(long id) {
		
		/*
		 * If a value is present, and the value matches the given Order, 
		 * return an Optional describing the value, otherwise return an empty Optional.
		 */
		Optional<Order> order = orderRepository.findById(id);
		Order orderData = new Order();
		BeanUtils.copyProperties(order, orderData);
		return orderData;
	}
	
	public void addOrder(Order order) {
		orderRepository.save(order);
	}
	
	
	public void updateOrder(Order order) {
		orderRepository.save(order);
	}
	
	public void deleteOrder(long id) {
		orderRepository.deleteById(id);
	}
	
	

}
