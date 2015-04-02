package ua.epam.rd;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.service.OrderService;
import ua.epam.rd.service.PizzaService;
import ua.epam.rd.service.SimpleOrderService;
import ua.epam.rd.service.SimplePizzaService;

public class AppRunner {
	
	private static final Logger logger = LogManager.getLogger(AppRunner.class);

	public static void main(String[] args) {
		
//		ConfigurableApplicationContext appContext =
//				new ClassPathXmlApplicationContext("springConfig.xml", "springConfig-LoockupMethodInjection.xml");
		
		ConfigurableApplicationContext appContextRepository = 
				new ClassPathXmlApplicationContext("springConfig.xml");
		
		ConfigurableApplicationContext appContextService = 
				new ClassPathXmlApplicationContext(
						new String[]{"springConfig-LoockupMethodInjection.xml"},
						appContextRepository);
		
		logger.debug("ApplicationContext is loaded.");
		
		System.out.println();
		System.out.println("---------- appContextRepository -------------");
		Arrays.asList(appContextRepository.getBeanDefinitionNames()).stream().forEach(System.out::println);
		System.out.println();
		System.out.println("---------- appContextService -------------");
		Arrays.asList(appContextService.getBeanDefinitionNames()).stream().forEach(System.out::println);
		System.out.println();
		
		
		
		// get EntityManager
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateMySQL");
//		EntityManager em = emf.createEntityManager();
		logger.debug("EntityManager is created.");

		PizzaService pizzaService = appContextService.getBean("pizzaService", PizzaService.class);
		logger.debug("PizzaService bean is gotten.");
		
		pizzaService.printAllPizzas();
		
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		
		OrderService orderService = appContextService.getBean("orderService", OrderService.class);
		
/*		
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
*/		
//		System.out.println(appContext.cl);
		
	}

}
