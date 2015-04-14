package ua.epam.rd.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Customer;
import ua.epam.rd.domain.Order;

@Transactional
@Repository("orderRepository")
public class JpaOrderRepository implements OrderRepository {

	@PersistenceContext(name = "HibernateMySQL") //, type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
//	@Override
//	public Long save(Order order) {
//		em.persist(order);
//		return order.getId();
//	}

	@Override
	public Order save(Order order) {
		em.persist(order);
		return order;
	}

	@Override
	public void update(Order order) {
		em.merge(order);
	}

	@Override
	public void delete(Order order) {
		em.remove(order);
	}

	@Override
	public List<Order> findCustomerOrdersForPeriod(Customer customer,
			Date dateFrom, Date dateTo) {

		// Criteria
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		
		Root<Order> rootOrder = query.from(Order.class);
		
		ParameterExpression<Customer> parameterCustomer = builder.parameter(Customer.class);
		ParameterExpression<Date> parameterDateFrom = builder.parameter(Date.class);
		ParameterExpression<Date> parameterDateTo = builder.parameter(Date.class);
		query.select(rootOrder).where(
				builder.equal(rootOrder.get("customer"), parameterCustomer),
				builder.greaterThan(rootOrder.get("date"), parameterDateFrom),
				builder.lessThan(rootOrder.get("date"), parameterDateTo)
				);
		
		TypedQuery<Order> typedQuery = em.createQuery(query);
		
		typedQuery.setParameter(parameterCustomer, customer);
		typedQuery.setParameter(parameterDateFrom, dateFrom);
		typedQuery.setParameter(parameterDateTo, dateTo);
		
		List<Order> orders = typedQuery.getResultList();
		
		return orders;
		
		
		// JPQL
//		String qlString = "SELECT o FROM Order o WHERE o.customer.id = " + customer.getId();
//		System.out.println(qlString);
//		TypedQuery<Order> typedQuery = em.createQuery(qlString, Order.class);
//		List<Order> orders = typedQuery.getResultList();
//		return orders;
	}

	@Override
	public List<Order> getAllOrders() {
		TypedQuery<Order> query = em.createQuery("select o from Order o", Order.class);
		return null;
	}

	@Override
	@Transactional
	public Order getOrderById(Long id) {
		Order order = em.find(Order.class, id);
		order.getItems().size();
		return em.find(Order.class, id);
	}


}
