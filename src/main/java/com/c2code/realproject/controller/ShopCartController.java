package com.c2code.realproject.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.c2code.realproject.entity.Order;
import com.c2code.realproject.entity.OrderDetail;
import com.c2code.realproject.entity.Phone;
import com.c2code.realproject.service.PhoneService;

@Controller
public class ShopCartController {

	private String path = "Cart/";

	@Autowired
	private PhoneService phoneService;

	@GetMapping("/gio-hang")
	public String giohang(HttpSession session, Model model) {
		Map<Integer, OrderDetail> cart = (Map<Integer, OrderDetail>) session.getAttribute("cart");
		Order order = (Order) session.getAttribute("order");
		model.addAttribute("cart", cart);
		model.addAttribute("order", order);
		return path + "gio-hang";
	}

	@PostMapping("/gio-hang")

	public String themvaogiohang(@RequestParam("item") int id, HttpSession session, Model model) {
		Phone phone = phoneService.get(id);
		Map<Integer, OrderDetail> cart = new HashMap<Integer, OrderDetail>();
		Order order = new Order();
		if (session.getAttribute("cart") != null) {
			cart = (Map<Integer, OrderDetail>) session.getAttribute("cart");
			order = (Order) session.getAttribute("order");
		}
		if (!cart.containsKey(id)) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setQuantity(phone.getNewprice());
			orderDetail.setPhone(phone);
			orderDetail.setAmount(1);
			cart.put(id, orderDetail);

			order.setQuantity(updatePrice(cart));
			order.setSaving(updateSaving(cart));
		} else {
			OrderDetail orderDetail = cart.get(id);
			orderDetail.setQuantity(phone.getNewprice());
			orderDetail.setAmount(orderDetail.getAmount() + 1);
			order.setQuantity(updatePrice(cart));
			order.setSaving(updateSaving(cart));
		}
		session.setAttribute("cart", cart);
		session.setAttribute("order", order);
		model.addAttribute("cart", cart);
		model.addAttribute("order", order);
		return path + "gio-hang";
	}

	public BigInteger updatePrice(Map<Integer, OrderDetail> map) {
		BigInteger price = BigInteger.ZERO;
		for (OrderDetail orderDetail : map.values()) {
			BigInteger price1 = orderDetail.getQuantity()
					.multiply(new BigInteger(String.valueOf(orderDetail.getAmount())));
			price = price.add(price1);
		}
		return price;
	}
	
	public BigInteger updateSaving(Map<Integer, OrderDetail> map) {
		BigInteger price = BigInteger.ZERO;
		for(OrderDetail orderDetail : map.values()) {
			Phone phone = orderDetail.getPhone();
			BigInteger price1 = phone.save();
			if(price1 != null) {
				price = price.add(price1.multiply(new BigInteger(String.valueOf(orderDetail.getAmount()))));
			}
		}
		return price;
	}
}
