package com.c2code.realproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopCartController {

	private String path = "Cart/";
	
	@GetMapping("/gio-hang")
	public String giohang(HttpSession session) {
		return path + "gio-hang";
	}
}
