package ua.epam.rd.pizzadeliveryservice.service;

import java.util.List;

import ua.epam.rd.pizzadeliveryservice.entity.Pizza;
import ua.epam.rd.pizzadeliveryservice.entity.PizzaType;
import ua.epam.rd.pizzadeliveryservice.repository.PizzaRepository;
import ua.epam.rd.pizzadeliveryservice.repository.TestPizzaRepositoryImpl;

public class SimplePizzaService implements PizzaService {

	private PizzaRepository pizzaRepository;
	
//	public SimplePizzaService() {
//		this.pizzaRepository = new TestPizzaRepositoryImpl();
//	}
	
	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaRepository.getAllPizzas();
	}

	@Override
	public List<Pizza> getPizzaByType(PizzaType type) {
		return pizzaRepository.getPizzaByType(type);
	}

	@Override
	public String pizzaToString(Pizza pizza) {
		return pizza.getName() + " - " +  pizza.getType().toString() + " - " + pizza.getPrice();
	}

	@Override
	public void printAllPizzas() {
		List<Pizza> pizzas = getAllPizzas();
		for (Pizza pizza : pizzas) {
			System.out.println(pizzaToString(pizza));
		}
	}

	public PizzaRepository getPizzaRepository() {
		return pizzaRepository;
	}

	public void setPizzaRepository(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

}
