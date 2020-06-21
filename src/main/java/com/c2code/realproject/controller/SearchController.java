package com.c2code.realproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.c2code.realproject.entity.Phone;
import com.c2code.realproject.service.PhoneService;

@Controller
public class SearchController {

	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/timkiem")
	public String search(@RequestParam("key")String key, Model model) {
		key = key.trim();
		List<Phone> phones = phoneService.getPhonesByName(key.toLowerCase());
		model.addAttribute("phones", phones);
		model.addAttribute("size", phones.size());
		model.addAttribute("key", key);
		return "Search/index";
	}
}
