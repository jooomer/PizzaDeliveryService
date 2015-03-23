package ua.epam.rd.pizzadeliveryservice.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.rd.pizzadeliveryservice.entity.Pizza;
import ua.epam.rd.pizzadeliveryservice.entity.PizzaType;

public interface PizzaRepository {
	
	List<Pizza> getAllPizzas();

	List<Pizza> getPizzaByType(PizzaType type);

	
}
