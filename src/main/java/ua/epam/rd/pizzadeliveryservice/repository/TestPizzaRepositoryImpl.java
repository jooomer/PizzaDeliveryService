package ua.epam.rd.pizzadeliveryservice.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.rd.pizzadeliveryservice.entity.Pizza;
import ua.epam.rd.pizzadeliveryservice.entity.PizzaType;

public class TestPizzaRepositoryImpl implements PizzaRepository {

	private List<Pizza> pizzas = new ArrayList<>();

	/**
	 * init pizza repozitory
	 */
//	public TestPizzaRepositoryImpl() {
//		this.pizzas.add(new Pizza("Pizza1", 10.0, PizzaType.VEGETARIAN));
//		this.pizzas.add(new Pizza("Pizza2", 20.0, PizzaType.MEET));
//		this.pizzas.add(new Pizza("Pizza3", 30.0, PizzaType.TOMATO));
//	}
	
	@Override
	public List<Pizza> getAllPizzas() {
		return pizzas;
	}

	@Override
	public List<Pizza> getPizzaByType(PizzaType type) {
		Pizza pizza = null;
		return null;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}
