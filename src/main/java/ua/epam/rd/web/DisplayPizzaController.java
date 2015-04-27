package ua.epam.rd.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.repository.PizzaRepository;

@Controller
public class DisplayPizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
	public String displayAllPizzas(Model model) {
		List<Pizza> listOfPizzas = pizzaRepository.getAllPizzas();
		for (Pizza pizza : listOfPizzas) {
			System.out.println(pizza.toString());
		}
		
		return "";
	}

}
