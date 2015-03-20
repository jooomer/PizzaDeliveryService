package ua.pizza.deliveryservice;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.pizzadeliveryservice.Order;
import ua.epam.rd.pizzadeliveryservice.Pizza;
import ua.epam.rd.service.OrderService;
import ua.epam.rd.service.PizzaService;
import ua.epam.rd.service.SimpleOrderService;
import ua.epam.rd.service.SimplePizzaService;

public class App {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContext =
				new ClassPathXmlApplicationContext("springConfig.xml");
		
//		PizzaService pizzaService = new SimplePizzaService();
		PizzaService pizzaService = appContext.getBean("pizzaService", PizzaService.class);
		
		
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		
		OrderService orderService = new SimpleOrderService();
//		OrderService orderService = appContext.getean("orderService", OrderService.class);
		
		
		Order newOrder1 = orderService.createNewOrder();
		newOrder1.addItems(pizzas.get(0), pizzas.get(1));
		orderService.placeOrder(newOrder1);
		
		Order newOrder2 = orderService.createNewOrder();
		newOrder2.addItems(pizzas.get(0));
		orderService.placeOrder(newOrder2);
		
		List<Order> orders = orderService.getAllOrders();
		
		orders.stream().forEach(System.out::println);
		
	}

}
