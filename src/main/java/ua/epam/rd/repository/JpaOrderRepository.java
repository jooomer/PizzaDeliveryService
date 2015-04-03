package ua.epam.rd.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Customer;
import ua.epam.rd.domain.Order;

@Transactional
@Repository("orderRepository")
public class JpaOrderRepository implements OrderRepository {

	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Override
	public Long save(Order order) {
		em.persist(order);
		return order.getId();
	}

	@Override
	public void update(Order order) {
		em.merge(order);
	}

	@Override
	public Order getOrderById(Long id) {
		return em.find(Order.class, new Long(id));
		
	}

	@Override
	public void delete(Order order) {
		em.remove(order);
	}

	@Override
	public List<Order> findCustomerOrdersForPeriod(Customer customer,
			Date dateFrom, Date dateTo) {

		// Criteria
		
		
		
		// JPQL
//		String qlString = "SELECT o FROM Order o WHERE o.customer.id = " + customer.getId()
//				+ "AND o.date BETWEEN " + dateFrom + " AND " + dateTo;
//		System.out.println(qlString);
//		TypedQuery<Order> typedQuery = em.createQuery(qlString, Order.class);
//		return typedQuery.getResultList();
	}

}
