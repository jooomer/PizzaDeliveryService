package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.pizzadeliveryservice.Pizza;
import ua.epam.rd.pizzadeliveryservice.PizzaType;
import ua.epam.rd.repository.PizzaRepository;

public class SimplePizzaService implements PizzaService {

	private PizzaRepository pizzaRepository;
	
	public SimplePizzaService() {

	}
	
	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaRepository.getAllPizzas();
	}

	@Override
	public List<Pizza> getPizzaByType(PizzaType type) {
		return pizzaRepository.getPizzaByType(type);
	}

}
