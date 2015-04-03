package ua.epam.rd.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;

/**
 * CRUD - Create, Retrieve, Update, Delete
 */
public interface PizzaRepository { //extends JpaRepository<Pizza, Long> {
	
	// Create
	Long save(Pizza pizza);

	// Retrieve
	Pizza getPizzaById(Long i);
	List<Pizza> getAllPizzas();
	List<Pizza> getPizzaByType(PizzaType type);

	// Update
	void update(Pizza pizza);

	// Delete
	void delete(Pizza pizza);

	
}
