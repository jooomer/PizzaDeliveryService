package ua.epam.rd.repository;

import java.util.List;
import java.util.Map;

import ua.epam.rd.pizzadeliveryservice.Order;
import ua.epam.rd.pizzadeliveryservice.Pizza;

public interface OrderRepository {

	public List<Order> getAllOrders();

	public Order getOrderById();

	public Long getNewOrderId();

	public void addItem(Pizza pizza);

	public void placeOrder(Order order);

}
