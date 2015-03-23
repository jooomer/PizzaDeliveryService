package ua.epam.rd.pizzadeliveryservice;

import java.util.List;






import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.pizzadeliveryservice.entity.Order;
import ua.epam.rd.pizzadeliveryservice.entity.Pizza;
import ua.epam.rd.pizzadeliveryservice.service.OrderService;
import ua.epam.rd.pizzadeliveryservice.service.PizzaService;
import ua.epam.rd.pizzadeliveryservice.service.SimpleOrderService;
import ua.epam.rd.pizzadeliveryservice.service.SimplePizzaService;

public class App {
	
	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContext =
				new ClassPathXmlApplicationContext("springConfig.xml", "springConfig-LoockupMethodInjection.xml");
		logger.debug("ApplicationContext is loaded.");
		
//		PizzaService pizzaService = new SimplePizzaService();
		PizzaService pizzaService = appContext.getBean("pizzaService", PizzaService.class);
		logger.debug("PizzaService bean is gotten.");
		
		pizzaService.printAllPizzas();
		
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		
//		OrderService orderService = new SimpleOrderService();
		OrderService orderService = appContext.getBean("orderService", OrderService.class);
		
		
		Order newOrder1 = orderService.createNewOrder();
		logger.debug("Order 'newOrder1' is created.");
		newOrder1.addItems(pizzas.get(0), pizzas.get(1));
		orderService.placeOrder(newOrder1);
		logger.debug("Order 'newOrder1' is placed to Repository.");

		Order newOrder2 = orderService.createNewOrder();
		logger.debug("Order 'order2' is created.");
		newOrder2.addItems(pizzas.get(0));
		orderService.placeOrder(newOrder2);
		logger.debug("Order 'newOrder2' is placed to Repository.");
		
		List<Order> orders = orderService.getAllOrders();
		
		orders.stream().forEach(System.out::println);
		
	}

}
