package ua.epam.rd.pizzadeliveryservice.entity;


public class Pizza {

	private String name;
	private Double price;
	private PizzaType type;
	
	public Pizza() {}
	
	public Pizza(String name, Double price, PizzaType type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public PizzaType getType() {
		return type;
	}

	public void setType(PizzaType type) {
		this.type = type;
	}
}
