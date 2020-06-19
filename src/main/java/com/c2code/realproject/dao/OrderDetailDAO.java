package com.c2code.realproject.dao;

import java.util.List;

import com.c2code.realproject.entity.OrderDetail;

public interface OrderDetailDAO extends GenericDAO<OrderDetail> {
	public List<OrderDetail> getOrderDetailsByOrderId(int id);
}
