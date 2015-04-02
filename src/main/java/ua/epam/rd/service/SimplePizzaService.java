package ua.epam.rd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;
import ua.epam.rd.repository.PizzaRepository;
import ua.epam.rd.repository.TestPizzaRepositoryImpl;

@Service("pizzaService")
public class SimplePizzaService implements PizzaService {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaRepository.getAllPizzas();
	}

	@Override
	public List<Pizza> getPizzaByType(PizzaType type) {
		return pizzaRepository.getPizzaByType(type);
	}

	@Override
	public String pizzaToString(Pizza pizza) {
		return pizza.getName() + " - " +  pizza.getType().toString() + " - " + pizza.getPrice();
	}

	@Override
	public void printAllPizzas() {
		List<Pizza> pizzas = getAllPizzas();
		for (Pizza pizza : pizzas) {
			System.out.println(pizzaToString(pizza));
		}
	}

	@Override
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
		
	}

}
