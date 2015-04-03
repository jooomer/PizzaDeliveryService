package ua.epam.rd.repository;

import ua.epam.rd.domain.Customer;

/**
 * CRUD - Create, Retrieve, Update, Delete
 */
public interface CustomerRepository {
	
	// Create
	Long save(Customer customer);

	// Retrieve
	Customer getCustomerById(Long id);
	
	// Update
	void update(Customer customer);
	
	// Delete
	void delete(Customer customer);
}
