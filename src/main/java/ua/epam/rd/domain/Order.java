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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private Double price = 0.;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "order", cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE,
				CascadeType.REFRESH })
	private Set<OrderItem> orderItems = new LinkedHashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Order() {
		date = new Date(Calendar.getInstance().getTimeInMillis());
	}
	
	public void addProduct(Pizza pizza) {
		System.out.println("--------------- Price: " + pizza.getPrice());
		price = price + pizza.getPrice();
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Order:   Id: " + id 
				+ "; 	Customer: " + customer.getId()
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
