package com.c2code.realproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c2code.realproject.dao.OrderDetailDAO;
import com.c2code.realproject.entity.OrderDetail;

@Repository
@Transactional
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetail> implements OrderDetailService {

	private OrderDetailDAO orderDetailDAO;
	
	@Autowired
	public OrderDetailServiceImpl(OrderDetailDAO orderDetailDAO) {
		dao = orderDetailDAO;
		this.orderDetailDAO = orderDetailDAO;
	}

	@Override
	public List<OrderDetail> getOrderDetailsByOrderId(int id) {
		// TODO Auto-generated method stub
		return orderDetailDAO.getOrderDetailsByOrderId(id);
	}

}
