package com.c2code.realproject.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2code.realproject.entity.OrderDetail;
import com.c2code.realproject.service.OrderDetailService;
import com.c2code.realproject.service.OrderService;

@Controller
@RequestMapping("/admin/orderdetail")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping("/{id}")
	@ResponseBody
	public List<OrderDetail> orderDetail(@PathVariable("id")int id, Model model) {
		List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(id);
		model.addAttribute("orderDetails", orderDetails);
		return orderDetails;
	}
}
