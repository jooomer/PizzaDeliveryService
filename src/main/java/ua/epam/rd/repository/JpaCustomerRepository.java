package ua.epam.rd.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Customer;

@Repository("customerRepository")
public class JpaCustomerRepository implements CustomerRepository {

	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Transactional
	@Override
	public Long save(Customer customer) {
//		em.merge(customer);
		em.persist(customer);
		return customer.getId();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return em.find(Customer.class, id);
	}

	@Override
	public void update(Customer customer) {
		em.merge(customer);
	}

	@Override
	public void delete(Customer customer) {
		em.remove(customer);
	}

}
