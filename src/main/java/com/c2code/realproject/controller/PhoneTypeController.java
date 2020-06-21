package com.c2code.realproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.c2code.realproject.service.PhoneService;
import com.c2code.realproject.service.PhoneTypeService;

@Controller(value = "phonetypeofuser")
@RequestMapping("/dtdd/type/")
public class PhoneTypeController {

	private String path = "Phonetype/";
	
	@Autowired
	private PhoneService phoneService;
	@Autowired
	private PhoneTypeService phoneTypeService;
	
	@GetMapping("/{phonetype}")
	public String getPhoneByType(@PathVariable("phonetype")String name, Model model) {
		model.addAttribute("phonetypes", phoneTypeService.getAll());
		model.addAttribute("nametype", name.toUpperCase());
		model.addAttribute("phone", phoneService.getPhoneByNamePhonetype(name));
		return path + "index";
	}
}
