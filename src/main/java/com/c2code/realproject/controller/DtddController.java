package com.c2code.realproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2code.realproject.entity.Phone;
import com.c2code.realproject.entity.PhoneImage;
import com.c2code.realproject.service.PhoneService;
import com.c2code.realproject.service.PhoneTypeService;

@Controller
@RequestMapping("/dtdd")
public class DtddController {

	private String path = "Phone/";

	@Autowired
	private PhoneTypeService phoneTypeService;
	@Autowired
	private PhoneService phoneService;
	
	
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("phonetypes", phoneTypeService.getAll());
		model.addAttribute("phone", phoneService.getAll());
		return path + "index";
	}
		
	
	@GetMapping("/{name}")
	public String phone(@PathVariable("name")String name, Model model) {
		Phone phone = phoneService.getPhoneBySlugName(name);
		model.addAttribute("phone", phone);
		List<PhoneImage> list = phone.getPhoneImages();
		Map<String, List<PhoneImage>> map = new HashMap<String, List<PhoneImage>>();
		for (PhoneImage phoneImage : list) {
			String key = phoneImage.getColor().getName();
			if(map.get(key) == null) map.put(key, new ArrayList<PhoneImage>());
		    map.get(key).add(phoneImage);
		}
		model.addAttribute("phoneImages", map);
		return path + "phone";
	}
}
