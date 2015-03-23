package ua.epam.rd.pizzadeliveryservice.repository;

import java.util.Map;

import ua.epam.rd.pizzadeliveryservice.entity.Order;
import ua.epam.rd.pizzadeliveryservice.service.PizzaService;

public class TestOrderRepositoryImpl implements OrderRepository {

	private PizzaService pizzaService;
	private Long counterId = 0L;
	
	@Override
	public Map<Long, Order> getAllOrders() {
		return this.orders;
	}

	@Override
	public Order getOrderById(Long id) {
		return this.orders.get(id);
	}

	@Override
	public Long getNewOrderId() {
		return ++this.counterId;
	}

	@Override
	public void placeOrder(Order order) {
		order.setId(counterId);
		this.orders.put(counterId, order);		
	}

	public PizzaService getPizzaService() {
		return pizzaService;
	}

	public void setPizzaService(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	public Long getCounterId() {
		return counterId;
	}

	public void setCounterId(Long counterId) {
		this.counterId = counterId;
	}


}
