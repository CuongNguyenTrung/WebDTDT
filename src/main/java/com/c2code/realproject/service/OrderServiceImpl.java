package com.c2code.realproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2code.realproject.dao.OrderDAO;
import com.c2code.realproject.entity.Order;
import com.c2code.realproject.entity.OrderDetail;

@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<Order> implements OrderService {

	
	private OrderDAO orderDAO;
	
	@Autowired
	public OrderServiceImpl(OrderDAO orderDAO) {
		// TODO Auto-generated constructor stub
		dao = orderDAO;
		this.orderDAO = orderDAO;
	}

	
	
}
