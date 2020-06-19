package com.c2code.realproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.c2code.realproject.entity.Order;
import com.c2code.realproject.entity.OrderDetail;

@Repository

public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {

	public OrderDAOImpl() {
		// TODO Auto-generated constructor stub
		clazz = Order.class;
	}

}
