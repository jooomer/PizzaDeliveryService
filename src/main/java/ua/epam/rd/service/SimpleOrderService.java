package ua.epam.rd.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.Status;
import ua.epam.rd.repository.OrderRepository;

@Service("orderService")
public class SimpleOrderService implements OrderService {

	private static final Logger logger = LogManager.getLogger(SimpleOrderService.class);

	@Autowired
	private OrderRepository orderRepository;
	
	public SimpleOrderService() {}
	
	public SimpleOrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	@Transactional
	public Order placeOrder(Order order) {
		if (!isWorkingDay()) 
			throw new IllegalStateException("This is not working day!");
		if (order.getOrderItems().isEmpty()) 
			throw new IllegalArgumentException("Order is empty!");
		return orderRepository.save(order);
	}
	
	public boolean isWorkingDay() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		return dayOfWeek != DayOfWeek.SUNDAY;
	}

	@Override
	public boolean cancelOrder(Long id, String email) {
		Order order = orderRepository.getOrderById(id);
		if (order.getCustomer().getEmail() == email) {
			
		}
		order.setStatus(Status.CANCELED);
//		orderId.status != Done, Cancel
		orderRepository.update(order);
		
		
		return false;
	}
	
	public void update(Order order) {
		if (order.getId() == null) 
			throw new IllegalArgumentException();
		orderRepository.update(order);
	}

}
