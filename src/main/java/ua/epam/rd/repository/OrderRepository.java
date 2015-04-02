package ua.epam.rd.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.Pizza;

public interface OrderRepository { //extends JpaRepository<Order, Long> {

	public Long save(Order order);

	
}
