package ua.epam.rd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ua.epam.rd.repository.OrderRepository;
import ua.epam.rd.service.OrderService;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Date date;

	private Double price;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	private Set<OrderItem> orderItems = new LinkedHashSet<>();
	

	public Order() {
		date = new Date(Calendar.getInstance().getTimeInMillis());
//		name = id.toString() + " - " + date;
	}
	
	public Order(Long id, Date date) {
		this.id = id;
		this.name = date.toString() + " - " + id;
		this.date = date;
	}
	
	public void addProduct(Pizza pizza) {
		OrderItem orderItem = new OrderItem();
		orderItem.setPizza(pizza);
		orderItem.setOrder(this);
		orderItems.add(orderItem);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	public String toString() {
		return "Order:   Id: " + id 
				+ ";    Name: " + name 
				+ ";    Date: " + date 
				+ ";    Price: " + price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("Init bean : afterPropertiesSet()");
//	}
	
//	public void init() {
//		System.out.println("Init bean : init()");
//	}

}
