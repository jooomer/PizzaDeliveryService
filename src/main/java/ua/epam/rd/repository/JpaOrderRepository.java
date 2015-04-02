package ua.epam.rd.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Order;

@Repository("orderRepository")
public class JpaOrderRepository implements OrderRepository {

	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Transactional
	@Override
	public Long save(Order order) {
		em.persist(order);
		return order.getId();
		
	}

}
