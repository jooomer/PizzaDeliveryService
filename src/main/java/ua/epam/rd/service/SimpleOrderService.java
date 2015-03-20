package ua.epam.rd.service;

import java.util.Date;
import java.util.List;

import org.omg.CORBA.RepositoryIdHelper;

import ua.epam.rd.pizzadeliveryservice.Order;
import ua.epam.rd.pizzadeliveryservice.Pizza;
import ua.epam.rd.repository.OrderRepository;

public class SimpleOrderService implements OrderService {

	private OrderRepository orderRepository;
	
	public SimpleOrderService() {
		
	}
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.getAllOrders();
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepository.getOrderById();
	}

	@Override
	public Order createNewOrder() {
		Long newOrderId = orderRepository.getNewOrderId();
		Date date = new Date();
		Order newOrder = new Order(newOrderId, date);
		return newOrder;
	}

	@Override
	public void addItems(Pizza... pizzas) {
		for (Pizza pizza : pizzas) {
			orderRepository.addItem(pizza);
		}
	}

	@Override
	public void placeOrder(Order order) {
		orderRepository.placeOrder(order);
	}

}
