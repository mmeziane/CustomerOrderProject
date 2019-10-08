package com.mmeziane.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmeziane.demo.model.Customer;
import com.mmeziane.demo.model.Order;
import com.mmeziane.demo.service.CustomerService;
import com.mmeziane.demo.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	public OrderController() {
		
	}
	
	/*
	 * This End point is responsible for fetching all orders available in our database.
	 */
	@RequestMapping(method = RequestMethod.GET , value = "/customers/{customerId}/orders" )
	public List<Order> getAllOrders(@PathVariable long orderId) {
		
		return orderService.getAllOrders(orderId);
	}
	
	
	@RequestMapping(value = "/customers/{customerId}/orders/{orderId}", method = RequestMethod.GET)
	public Order getOrder(@PathVariable long orderId, @PathVariable long customerId) {
		
		return orderService.getOrder(orderId);
	}
	
	/*
	 * This End point is responsible for fetching total number of orders.
	 */

	
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	 public long countOrders() {
	 return orderService.countOrders();
	 }

	/*
	 * This End point is responsible for adding one order.
	 */
	
	@RequestMapping(method=RequestMethod.POST, value="/customers/{customerId}/orders")
	public void addOrder(@Valid @RequestBody Order order, @PathVariable long customerId) {
		
		Customer customerOrder = customerService.getCustomer(customerId);
		order.setCustomer(customerOrder);
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{customerId}/orders/{orderId}")
	public void updateOrder(@Valid @RequestBody Order order, @PathVariable long customerId, @PathVariable long orderId) {
		Customer orderCustomer = customerService.getCustomer(customerId);
	    Order updateOrder = orderService.getOrder(orderId);
	    updateOrder.setCustomer( orderCustomer );
	    updateOrder.setOrderName(order.getOrderName());
	    updateOrder.setDetails(order.getDetails());
		orderService.updateOrder( updateOrder);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/customers/{customerId}/orders/{orderId}")
	public void deleteOrder(@PathVariable long orderId) {
		orderService.deleteOrder(orderId);
	}
	
	

}
