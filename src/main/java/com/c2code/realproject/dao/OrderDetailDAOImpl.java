package com.c2code.realproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.c2code.realproject.entity.OrderDetail;

@Repository
public class OrderDetailDAOImpl extends GenericDAOImpl<OrderDetail> implements OrderDetailDAO {

	public OrderDetailDAOImpl() {
		clazz = OrderDetail.class;
	}

	@Override
	public List<OrderDetail> getOrderDetailsByOrderId(int id) {
		Session session = createSession();
		List<OrderDetail> orderDetails = session
				.createQuery("select od from OrderDetail od join od.order o where o.id = :id", OrderDetail.class)
				.setParameter("id", id).list();
		return orderDetails;
	}

}
