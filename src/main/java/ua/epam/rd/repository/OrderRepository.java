package ua.epam.rd.repository;

import java.util.Date;
import java.util.List;

import ua.epam.rd.domain.Customer;
import ua.epam.rd.domain.Order;

/**
 * CRUD - Create, Retrieve, Update, Delete
 */
public interface OrderRepository { //extends JpaRepository<Order, Long> {

	// Create
	Order save(Order order);

	// Retrieve
	Order getOrderById(Long id);
	List<Order> findCustomerOrdersForPeriod(Customer customer, Date dateFrom, Date dateTo);
		
	// Update
	void update(Order order);

	// Delete
	void delete(Order order);

	List<Order> getAllOrders();
	
}
