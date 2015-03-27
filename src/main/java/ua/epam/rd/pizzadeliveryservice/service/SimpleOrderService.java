package ua.epam.rd.pizzadeliveryservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import ua.epam.rd.pizzadeliveryservice.entity.Order;
import ua.epam.rd.pizzadeliveryservice.repository.OrderRepository;

@Service
public class SimpleOrderService implements OrderService, ApplicationContextAware {

	private static final Logger logger = LogManager.getLogger(SimpleOrderService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	protected Order createOrder() {
		return this.applicationContext.getBean("newOrder", Order.class);
	}
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> ordersList = new ArrayList<>();
		Map<Long, Order> ordersMap = orderRepository.getAllOrders();
		for (Entry<Long, Order> order : ordersMap.entrySet()) {
			ordersList.add(order.getValue());
		}
		return ordersList;
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepository.getOrderById(id);
	}

	@Override
	public Order createNewOrder() {
		
		logger.debug("Method 'createNewOrder()' started.");
		
		Long newOrderId = orderRepository.getNewOrderId();
		Date date = new Date();
//		Order newOrder = new Order(newOrderId, date); 
		// Избавиться от этой строчки
		// должет делать Spring
		// 5.4.6 Method injection (Lookup method injection)
		// сделать оба метода
		
		Order newOrder = createOrder();
		newOrder.setId(newOrderId);
		newOrder.setDate(date);
		newOrder.createName();
		
		return newOrder;
	}

	@Override
	public void placeOrder(Order order) {
		orderRepository.placeOrder(order);
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


}
