package ua.epam.rd.repository;

import java.util.List;

import ua.epam.rd.pizzadeliveryservice.Pizza;
import ua.epam.rd.pizzadeliveryservice.PizzaType;

public interface PizzaRepository {

	List<Pizza> getAllPizzas();

	List<Pizza> getPizzaByType(PizzaType type);

	
}
