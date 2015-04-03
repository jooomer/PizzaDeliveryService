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

import ua.epam.rd.domain.Customer;
import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.OrderItem;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;
import ua.epam.rd.domain.Souce;
import ua.epam.rd.domain.Status;
import ua.epam.rd.repository.CustomerRepository;
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
	private static CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContextRepository = 
				new ClassPathXmlApplicationContext("springConfig.xml");
		logger.debug("ApplicationContext is created.");

		pizzaRepository = appContextRepository.getBean("pizzaRepository", PizzaRepository.class);
		orderRepository = appContextRepository.getBean("orderRepository", OrderRepository.class);
		customerRepository = appContextRepository.getBean("customerRepository", CustomerRepository.class);
		
		// init Pizzas
		List<Pizza> pizzas = initPizzas();
		
		// create Orders
		Order order1 = new Order();
		order1.addProduct(pizzas.get(0));
		order1.addProduct(pizzas.get(1));
		order1.setStatus(Status.NEW);
//		orderRepository.save(order1); // should not be persisted
		
		Order order2 = new Order();
		order2.addProduct(pizzas.get(0));
		order2.addProduct(pizzas.get(2));
		order2.setStatus(Status.NEW);
//		orderRepository.save(order2); // should not be persisted
		
		Order order3 = new Order();
		order3.addProduct(pizzas.get(1));
		order3.addProduct(pizzas.get(2));
		order3.setStatus(Status.NEW);
//		orderRepository.save(order2); // should not be persisted
		
		// create Customers
		Customer customer1 = new Customer();
		customer1.addOrder(order1);
		customer1.addOrder(order2);
		customerRepository.save(customer1); // persist orders by cascade
		
		Customer customer2 = new Customer();
		customer2.addOrder(order3);
		customerRepository.save(customer2); // persist orders by cascade
		
		
		
		// get some orders
		List<Order> orders = orderRepository.findCustomerOrdersForPeriod(customer2, null, null);
		for (Order order : orders) {
			System.out.println("Order: " + order);
		}
		
		
		// add additional pizzas to existing order
//		order2.addProduct(pizzas.get(2));
//		orderRepository.update(order2);
//		orderRepository.update(order2);
//		order1.setStatus(Status.IN_PROGRSS);
//		orderRepository.update(order1);
//		order1.setStatus(Status.DONE);
//		orderRepository.update(order1);
//		pizzas.get(0).setName("11111111111111");
//		pizzaRepository.update(pizzas.get(0));
		
		
		// delete pizza
//		pizzaRepository.delete(pizzas.get(0));
		
//		Pizza newPizza = pizzaRepository.(Pizza.class, pizza.getId());
		
//		System.out.println("newPizza: " + newPizza);

	}

	private static List<Pizza> initPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		
		Pizza pizza1 = new Pizza();
		pizza1.setName("Oliva");
		pizza1.setType(PizzaType.VEGETARIAN);
		pizza1.setPrice(123.1);
		System.out.println("------ Pizza before: " + pizza1);
		pizzaRepository.save(pizza1);
		System.out.println("------ Pizza after: " + pizza1);
		pizzas.add(pizza1);
		
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
