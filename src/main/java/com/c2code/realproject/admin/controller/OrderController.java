package com.c2code.realproject.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.c2code.realproject.service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

	private String path = "Admin/Order/";
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("orders", orderService.getAll());
		return path + "index";
	}
}
