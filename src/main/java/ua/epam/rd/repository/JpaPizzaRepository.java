package ua.epam.rd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;

@Repository("pizzaRepository")
public class JpaPizzaRepository implements PizzaRepository {
	
	private static final Logger logger = LogManager.getLogger(JpaPizzaRepository.class);

	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
		
	public JpaPizzaRepository() {
		logger.debug("Constructor JpaPizzaRepository() started");
	}
		
	@Override
	public List<Pizza> getAllPizzas() {
		return null;
	}

	@Override
	public List<Pizza> getPizzaByType(PizzaType type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public Long save(Pizza pizza) {
		em.persist(pizza);
		return pizza.getId();
	}

}
