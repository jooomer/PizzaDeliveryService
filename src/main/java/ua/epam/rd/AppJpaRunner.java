package ua.epam.rd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.login.AppConfigurationEntry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.OrderItem;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;
import ua.epam.rd.repository.OrderRepository;
import ua.epam.rd.repository.PizzaRepository;
import ua.epam.rd.service.OrderService;
import ua.epam.rd.service.PizzaService;
import ua.epam.rd.service.SimpleOrderService;
import ua.epam.rd.service.SimplePizzaService;

public class AppJpaRunner {

	private static final Logger logger = LogManager.getLogger(AppJpaRunner.class);

	private static PizzaRepository pizzaRepository;
	private static OrderRepository orderRepository;
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContextRepository = 
				new ClassPathXmlApplicationContext("springConfig.xml");
		logger.debug("ApplicationContext is created.");

		pizzaRepository = appContextRepository.getBean("pizzaRepository", PizzaRepository.class);
		orderRepository = appContextRepository.getBean("orderRepository", OrderRepository.class);
//		PizzaService pizzaService = appContextRepository.getBean("pizzaService", PizzaService.class);
		
		// init Pizzas
		List<Pizza> pizzas = initPizzas();
				
		Order order1 = new Order();
		order1.addProduct(pizzas.get(0));
		order1.addProduct(pizzas.get(1));
		orderRepository.save(order1);
		
//		Pizza newPizza = pizzaRepository.(Pizza.class, pizza.getId());
		
//		System.out.println("newPizza: " + newPizza);

	}

	private static List<Pizza> initPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		
		Pizza pizza1 = new Pizza();
		pizza1.setName("Oliva");
		pizza1.setType(PizzaType.VEGETARIAN);
		pizza1.setPrice(123.1);
		System.out.println("Before: " + pizza1);
		pizzaRepository.save(pizza1);
		pizzas.add(pizza1);
		System.out.println("After: " + pizza1);
		
		Pizza pizza2 = new Pizza();
		pizza2.setName("Meet");
		pizza2.setType(PizzaType.MEET);
		pizza2.setPrice(189.5);
		pizzaRepository.save(pizza2);
		pizzas.add(pizza2);
		
		Pizza pizza3 = new Pizza();
		pizza3.setName("Tomato");
		pizza3.setType(PizzaType.TOMATO);
		pizza3.setPrice(158.2);
		pizzaRepository.save(pizza3);
		pizzas.add(pizza3);
		
		return pizzas;
	
	}

}
