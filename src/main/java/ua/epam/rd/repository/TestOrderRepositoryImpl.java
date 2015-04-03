package ua.epam.rd.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ua.epam.rd.domain.Customer;
import ua.epam.rd.domain.Order;
import ua.epam.rd.service.PizzaService;

@Repository
public class TestOrderRepositoryImpl implements OrderRepository {

	@Override
	public Long save(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Order order1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrderById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> findCustomerOrdersForPeriod(Customer customer,
			Date daterom, Date dateTo) {
		// TODO Auto-generated method stub
		return null;
	}



}
