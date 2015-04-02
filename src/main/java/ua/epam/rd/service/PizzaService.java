package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;

public interface PizzaService {
	
	List<Pizza> getAllPizzas();
	
	List<Pizza> getPizzaByType(PizzaType type);
	
	String pizzaToString(Pizza pizza);
	
	void printAllPizzas();

	void save(Pizza pizza);

}
