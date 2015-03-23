package ua.epam.rd.pizzadeliveryservice.service;

import java.util.List;

import ua.epam.rd.pizzadeliveryservice.entity.Pizza;
import ua.epam.rd.pizzadeliveryservice.entity.PizzaType;

public interface PizzaService {
	
	List<Pizza> getAllPizzas();
	
	List<Pizza> getPizzaByType(PizzaType type);
	
	String pizzaToString(Pizza pizza);
	
	void printAllPizzas();

}
