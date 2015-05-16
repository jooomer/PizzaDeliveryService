package ua.epam.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;

@Transactional
@Repository("pizzaRepository")
public class JpaPizzaRepository implements PizzaRepository {
	
	private static final Logger logger = LogManager.getLogger(JpaPizzaRepository.class);

	@PersistenceContext(name = "HibernateHSQL")
	private EntityManager em;
		
	public JpaPizzaRepository() {
		logger.debug("Constructor JpaPizzaRepository() started");
	}
		
	@Override
	public List<Pizza> getAllPizzas() {
		TypedQuery<Pizza> query = em.createQuery("select o from Pizza o", Pizza.class);
		return query.getResultList();
	}

	@Override
	public List<Pizza> getPizzaByType(PizzaType type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Long save(Pizza pizza) {
		em.persist(pizza);
		return pizza.getId();
	}

	@Override
	public void delete(Pizza pizza) {
		pizza = em.find(Pizza.class, pizza.getId());
		em.remove(pizza);
	}

	@Override
	public Pizza getPizzaById(Long id) {
		return em.find(Pizza.class, id);
//		return em.getReference(Pizza.class, i);
	}

	@Override
	public void update(Pizza pizza) {
		em.merge(pizza);
		
	}

}
