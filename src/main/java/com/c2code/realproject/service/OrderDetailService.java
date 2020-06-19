package com.c2code.realproject.service;

import java.util.List;

import com.c2code.realproject.entity.OrderDetail;

public interface OrderDetailService extends Service<OrderDetail> {
	public List<OrderDetail> getOrderDetailsByOrderId(int id);
}
