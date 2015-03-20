package ua.epam.rd.pizzadeliveryservice;

import java.util.Date;
import java.util.List;

import ua.epam.rd.repository.OrderRepository;
import ua.epam.rd.service.OrderService;

public class Order {
	
	private OrderRepository orderRepository;
	
	private Long id;
	private Date date;
	private String name;
	private List<Pizza> pizzas;
	private Double price;
	
	public Order(Long id, Date date) {
		this.name = date.toString() + id;
	}
	
	public void addItems(Pizza... pizzas) {
		for (Pizza pizza : pizzas) {
			this.pizzas.add(pizza);
		}
	}
	

}
