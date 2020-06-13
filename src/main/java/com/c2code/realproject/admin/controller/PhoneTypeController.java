package com.c2code.realproject.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.c2code.realproject.entity.PhoneType;
import com.c2code.realproject.service.PhoneTypeService;
import com.c2code.realproject.utils.FileUtils;

@Controller
@RequestMapping("/admin/phonetype")
public class PhoneTypeController {

	private String path = "Admin/PhoneType/";
	private String dir = "phonetype";

	@Autowired
	private PhoneTypeService phoneTypeService;

	@GetMapping("/index")
	public String index(Model model) {
		List<PhoneType> list = phoneTypeService.getAll();
		model.addAttribute("list", list);
		return path + "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("phonetype", new PhoneType());
		return path + "create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("phonetype") PhoneType phonetype, @RequestParam("img") MultipartFile file,
			RedirectAttributes redirect) {
		String image = new FileUtils(file, dir).handle();
		phonetype.setImage(image);
		phoneTypeService.save(phonetype);
		redirect.addFlashAttribute("message", "Tạo mới thành công hãng điện thoại");
		return "redirect:index";
	}
	
	@GetMapping("/{id}")
	public String update(@PathVariable("id")int id, Model model) {
		model.addAttribute("phonetype", phoneTypeService.get(id));
		return path + "update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("phonetype")PhoneType phonetype, @RequestParam(name = "img")MultipartFile file,
			RedirectAttributes redirect) {
		String image = new FileUtils(file, dir).handle();
		if(image != null) {
			System.out.println(image);
			phonetype.setImage(image);
		}
		phoneTypeService.update(phonetype);
		redirect.addFlashAttribute("message", "Cập nhật thành công hãng điện thoại");
		return "redirect:index";
	}
	
	@PostMapping("/{id}")
	public String delete(@PathVariable("id")int id, RedirectAttributes redirect) {
		phoneTypeService.delete(id);
		redirect.addFlashAttribute("message", "Xoá thành công hãng");
		return "redirect:index";
	}
	
}
