package ua.epam.rd.service;

import java.util.List;

import ua.epam.rd.pizzadeliveryservice.Pizza;
import ua.epam.rd.pizzadeliveryservice.PizzaType;

public interface PizzaService {
	
	List<Pizza> getAllPizzas();
	List<Pizza> getPizzaByType(PizzaType type);

}
