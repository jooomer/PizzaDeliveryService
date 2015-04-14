package ua.epam.rd.repository;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.Status;
import ua.epam.rd.service.OrderService;
import ua.epam.rd.service.SimpleOrderService;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class SimpleOrderServiceTest {
	
	private static final Logger logger = LogManager.getLogger(SimpleOrderServiceTest.class);

	@Test
	public void placeOrder_CallOneTime() {
		logger.debug("--- start");
		
		OrderRepository mockOrderRepository = mock(OrderRepository.class);
		OrderService orderService = new SimpleOrderService(mockOrderRepository);
		
//		Order order = new Order();
//		Pizza pizza = new Pizza();
//		pizza.setPrice(100.);
//		order.addPizza(pizza);
		
		Order order = mock(Order.class, RETURNS_DEEP_STUBS);
		when(order.getOrderItems().isEmpty()).thenReturn(Boolean.FALSE);
		orderService.placeOrder(order);

		verify(mockOrderRepository, times(1)).save(order);

//		fail("Not yet implemented");


	}

	@Test(expected = IllegalStateException.class)
	public void placeOrder_IsWorkingDay() {
		logger.debug("--- start");
		
		OrderRepository mockOrderRepository = mock(OrderRepository.class);
		
		// make spy
		SimpleOrderService orderService = spy(new SimpleOrderService(mockOrderRepository));
		
		when(orderService.isWorkingDay()).thenReturn(Boolean.FALSE);
		
		Order order = new Order();
		Pizza pizza = new Pizza();
		pizza.setPrice(100.);
		order.addPizza(pizza);
		orderService.placeOrder(order);

		System.out.println("New order status: " + order.getStatus());
		
		verify(mockOrderRepository).save(anyObject());

//		fail("Not yet implemented");
	}

	
	// 1. noOrderId - IllegalArgumetException()
	@Test(expected = IllegalArgumentException.class)
	public void update_NoOrderId() {
		logger.debug("--- start");
		
		OrderRepository mockOrderRepository = mock(OrderRepository.class);
		
		// make spy
		SimpleOrderService orderService = new SimpleOrderService(mockOrderRepository);
		
		Order order = new Order();
		orderService.update(order);

		verify(mockOrderRepository).update(order);

//		fail("Not yet implemented");
	}

// 3. when order.update - status must be Cancel	
	@Test(expected = IllegalArgumentException.class)
	public void cancelOrder_BeforeUpdateStatusMustBeCancel() {
		logger.debug("--- start");
		
		OrderRepository mockOrderRepository = mock(OrderRepository.class);
		SimpleOrderService orderService = new SimpleOrderService(mockOrderRepository);
		
		Order order = new Order();
		order.setStatus(Status.NEW);
		
		when(mockOrderRepository.getOrderById(anyLong())).thenReturn(order);
		orderService.cancelOrder(anyLong(), anyString());

		verify(mockOrderRepository).update(order);

//		fail("Not yet implemented");
	}

	
	
	// 2. order.update()
}


