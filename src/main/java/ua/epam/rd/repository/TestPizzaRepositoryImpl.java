package ua.epam.rd.repository;

import java.util.ArrayList;
import java.util.List;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;

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

	@Override
	public Long save(Pizza pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza getPizzaById(Long i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

}
