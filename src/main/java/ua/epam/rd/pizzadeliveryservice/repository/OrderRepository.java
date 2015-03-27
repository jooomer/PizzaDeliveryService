package ua.epam.rd.pizzadeliveryservice.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.epam.rd.pizzadeliveryservice.entity.Order;
import ua.epam.rd.pizzadeliveryservice.entity.Pizza;

public interface OrderRepository {

	public Map<Long, Order> getAllOrders();

	public Order getOrderById(Long id);

	public Long getNewOrderId();

	public void placeOrder(Order order);

}
