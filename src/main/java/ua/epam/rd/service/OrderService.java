package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.pizzadeliveryservice.Order;
import ua.epam.rd.pizzadeliveryservice.Pizza;

public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public Order getOrderById(Long id);

	public Order createNewOrder();

	public void addItems(Pizza... pizza);
	
	public void placeOrder(Order order);

}
