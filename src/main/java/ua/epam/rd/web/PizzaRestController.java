package ua.epam.rd.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.service.PizzaService;

@RestController
public class PizzaRestController {

	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "hello")
	@ResponseBody
	public String hello() {
		return "Hello from RESTController";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "pizza")
	public List<Pizza> getAllPizzas() {
		System.out.println("List<Pizza> getAllPizzas()");
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		System.out.println(pizzas);
		return pizzas;
	}
	
	@RequestMapping(method = RequestMethod.GET, 
			value = "pizza/{id}/item/{itemid}")
	public Pizza getPizzaById(@PathVariable Long id, @PathVariable Long itemid) {
		System.out.println("List<Pizza> getAllPizzas()");
		Pizza pizza = pizzaService.getPizzaById(id);
		System.out.println(pizza);
		return pizza;
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			value = "pizza",
			headers = "Content-Type=application/json")
	public void addPizza(Pizza pizza) {
		System.out.println(pizza);
		pizzaService.save(pizza);
	}
}
