package ua.epam.rd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import ua.epam.rd.domain.Order;
import ua.epam.rd.repository.OrderRepository;

@Service
public class SimpleOrderService implements OrderService {

	private static final Logger logger = LogManager.getLogger(SimpleOrderService.class);
	

}
