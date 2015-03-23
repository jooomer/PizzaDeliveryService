package ua.epam.rd.pizzadeliveryservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.epam.rd.pizzadeliveryservice.entity.Order;
import ua.epam.rd.pizzadeliveryservice.entity.Pizza;

public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public Order getOrderById(Long id);

	public Order createNewOrder();

	public void placeOrder(Order order);


}
