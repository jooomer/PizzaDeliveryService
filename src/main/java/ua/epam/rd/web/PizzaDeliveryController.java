package ua.epam.rd.web;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PizzaDeliveryController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String enterToPizzaService() {
		System.out.println("----------------------------");
//		StringBuilder sb = new StringBuilder();
//		for (String s : applicationContext.getBeanDefinitionNames()) {
//			sb.append(s).append(" ");
//		}
//		
//		return sb.toString();
		
		return "Hello Spring!";
	}
	
}
