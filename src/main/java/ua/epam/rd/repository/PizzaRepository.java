package ua.epam.rd.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;

public interface PizzaRepository { //extends JpaRepository<Pizza, Long> {
	
	List<Pizza> getAllPizzas();

	List<Pizza> getPizzaByType(PizzaType type);

	Long save(Pizza pizza);

	
}
