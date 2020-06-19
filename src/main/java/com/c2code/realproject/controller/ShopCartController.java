package com.c2code.realproject.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.c2code.realproject.entity.Order;
import com.c2code.realproject.entity.OrderDetail;
import com.c2code.realproject.entity.Phone;
import com.c2code.realproject.service.OrderService;
import com.c2code.realproject.service.PhoneService;

@Controller
public class ShopCartController {

	private String path = "Cart/";

	@Autowired
	private PhoneService phoneService;
	@Autowired
	private OrderService orderService;

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

	@PostMapping("/gio-hang/delete/{id}")
	public String remove(@PathVariable("id") int id, HttpSession session) {
		Map<Integer, OrderDetail> cart = (Map<Integer, OrderDetail>) session.getAttribute("cart");
		Order order = (Order) session.getAttribute("order");
		cart.remove(id);
		if (cart.keySet().size() == 0) {
			session.removeAttribute("cart");
			session.removeAttribute("order");
		} else {
			session.setAttribute("cart", cart);
			order.setQuantity(updatePrice(cart));
			order.setSaving(updateSaving(cart));
		}

		return "redirect:/gio-hang";
	}

	@PostMapping("/gio-hang/xac-nhan")
	public String datHang(HttpSession session, Model model, @RequestParam("username") String username,
			@RequestParam("sdt") String sdt, @RequestParam("status") String status, RedirectAttributes redirect) {
		Order order = (Order) session.getAttribute("order");
		order.setUsername(username);
		order.setSdt(sdt);
		order.setStatus(status);
		Map<Integer, OrderDetail> map = (Map<Integer, OrderDetail>) session.getAttribute("cart");
		for (OrderDetail orderDetail : map.values()) {
			orderDetail.setCreateAt(null);
			order.addOrderDetail(orderDetail);
		}
		orderService.save(order);
		session.removeAttribute("cart");
		session.removeAttribute("order");
		redirect.addFlashAttribute("message", "Đặt hàng thành công");
		return "redirect:/gio-hang";
	}

	@PostMapping("/updateCart")
	@ResponseBody
	public Order updateCart(@RequestParam("id") int id, @RequestParam("operator") String operator,
			HttpSession session) {
		System.out.println(id + " " + operator);
		Map<Integer, OrderDetail> cart = (Map<Integer, OrderDetail>) session.getAttribute("cart");
		Order order = (Order) session.getAttribute("order");
		OrderDetail orderDetail = cart.get(id);
		if (operator.equals("+"))
			orderDetail.setAmount(orderDetail.getAmount() + 1);
		else if (operator.equals("-"))
			orderDetail.setAmount(orderDetail.getAmount() - 1);
		order.setQuantity(updatePrice(cart));
		order.setSaving(updateSaving(cart));
		return order;
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
		for (OrderDetail orderDetail : map.values()) {
			Phone phone = orderDetail.getPhone();
			BigInteger price1 = phone.save();
			if (price1 != null) {
				price = price.add(price1.multiply(new BigInteger(String.valueOf(orderDetail.getAmount()))));
			}
		}
		return price;
	}
}
