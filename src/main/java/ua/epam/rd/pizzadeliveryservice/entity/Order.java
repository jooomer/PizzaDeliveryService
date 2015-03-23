package ua.epam.rd.pizzadeliveryservice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.epam.rd.pizzadeliveryservice.repository.OrderRepository;
import ua.epam.rd.pizzadeliveryservice.service.OrderService;

public class Order {
	
	private OrderRepository orderRepository;
	
	private Long id;
	private Date date;
	private String name;
	private List<Pizza> pizzas = new ArrayList<>();
	private double price;
	
	public Order() {}
	
	public Order(Long id, Date date) {
		this.id = id;
		this.name = date.toString() + " - " + id;
		this.date = date;
	}
	
	public void createName() {
		this.name = this.date.toString() + " - " + this.id;
	}
	
	public void addItems(Pizza... pizzas) {
		for (Pizza pizza : pizzas) {
			this.pizzas.add(pizza);
			this.price += pizza.getPrice();
		}
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Order:   Id: " + id 
				+ ";    Name: " + name 
				+ ";    Date: " + date 
				+ ";    Price: " + price;
	}

}
