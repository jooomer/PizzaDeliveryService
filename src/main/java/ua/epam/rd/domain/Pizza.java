package ua.epam.rd.domain;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizza implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private PizzaType type;
	
	@OneToMany(mappedBy = "pizza")
	private Set<OrderItem> orderIrems = new LinkedHashSet<>();
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Pizza Id=" + id + "; name=" + name + "; type=" + type + "; price=" + price;
	}

	public Set<OrderItem> getOrderIrems() {
		return orderIrems;
	}

	public void setOrderIrems(Set<OrderItem> orderIrems) {
		this.orderIrems = orderIrems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((orderIrems == null) ? 0 : orderIrems.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderIrems == null) {
			if (other.orderIrems != null)
				return false;
		} else if (!orderIrems.equals(other.orderIrems))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
