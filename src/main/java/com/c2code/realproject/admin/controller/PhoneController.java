package com.c2code.realproject.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.c2code.realproject.entity.Color;
import com.c2code.realproject.entity.Phone;
import com.c2code.realproject.entity.PhoneDetail;
import com.c2code.realproject.entity.PhoneImage;
import com.c2code.realproject.object.DataPhone;
import com.c2code.realproject.service.ColorService;
import com.c2code.realproject.service.PhoneImageService;
import com.c2code.realproject.service.PhoneService;
import com.c2code.realproject.service.PhoneTypeService;
import com.c2code.realproject.utils.FileUtils;
import com.c2code.realproject.utils.ListMultipartUtils;

@Controller
@RequestMapping("/admin/phone")
public class PhoneController {

	private String path = "Admin/Phone/";
	private String dir = "phone";

	@Autowired
	private PhoneService phoneService;
	@Autowired
	private PhoneTypeService phoneTypeService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private PhoneImageService phoneImageService;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("list", phoneService.getAll());
		return path + "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		DataPhone dataPhone = new DataPhone();
		List<Color> colors = colorService.getAll();
		dataPhone.init(colors);
		model.addAttribute("dataPhone", dataPhone);
		model.addAttribute("phoneTypes", phoneTypeService.getAll());
		model.addAttribute("colors", colors);
		return path + "create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("dataPhone") DataPhone dataPhone, RedirectAttributes redirect) {
		// Handle image of phone
		MultipartFile image = dataPhone.getImage();
		FileUtils file = new FileUtils(image, dir);
		String imageString = file.handle();

		// Handle phone
		Phone phone = dataPhone.getPhone();

		phone.setImage(imageString);

		// Handle phoneDetail
		PhoneDetail phoneDetail = dataPhone.getPhoneDetail();
		phone.addPhoneDetail(phoneDetail);

		// Handle image đưa về map
		ListMultipartUtils listUtils = new ListMultipartUtils(dir);
		Map<Integer, List<String>> listImages = new HashMap<Integer, List<String>>();
		Map<Integer, List<MultipartFile>> phoneImages = dataPhone.getPhoneImages();
		Set<Integer> keySets = phoneImages.keySet();
		for (Integer key : keySets) {
			List<MultipartFile> listImage = phoneImages.get(key);
			listUtils.setFiles(listImage);
			List<String> images = listUtils.handle();
			Color color = colorService.get(key);
			for (String im : images) {
				PhoneImage img = new PhoneImage();
				img.setImage(im);
				img.setColor(color);
				phone.addPhoneImage(img);
			}
		}

		// Save Image

		phoneService.save(phone);
		redirect.addFlashAttribute("message", "Tạo điện thoại thành công");
		return "redirect:index";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("dataPhone") DataPhone dataPhone, RedirectAttributes redirect) {
		// Handle Image
		MultipartFile file = dataPhone.getImage();
		FileUtils fileUtils = new FileUtils(file, dir);
		String imageString = fileUtils.handle();

		// Get phone and update
		Phone phone = dataPhone.getPhone();
		Phone oldPhone = phoneService.get(phone.getId());
		if (imageString != null)
			phone.setImage(imageString);
		else
			phone.setImage(oldPhone.getImage());

		// Get phone detail
		PhoneDetail oldPhoneDetail = oldPhone.getPhoneDetail();
		PhoneDetail phoneDetail = dataPhone.getPhoneDetail();
		phoneDetail.setId(oldPhoneDetail.getId());
		phone.addPhoneDetail(phoneDetail);
		
		// Handle image
		ListMultipartUtils listUtils = new ListMultipartUtils(dir);
		Map<Integer, List<String>> listImages = new HashMap<Integer, List<String>>();
		Map<Integer, List<MultipartFile>> phoneImages = dataPhone.getNewPhoneImages();
		
		Set<Integer> keySets = phoneImages.keySet();
		for (Integer key : keySets) {
			List<MultipartFile> listImage = phoneImages.get(key);
			listUtils.setFiles(listImage);
			List<String> images = listUtils.handle();
			Color color = colorService.get(key);
			for (String im : images) {
				PhoneImage img = new PhoneImage();
				img.setImage(im);
				img.setColor(color);
				System.out.println(im + "LOL");
				phone.addPhoneImage(img);
			}
		}
		phoneService.update(phone);
		redirect.addFlashAttribute("message", "Cập nhật thành công điện thoại");
		return "redirect:index";
	}

	@GetMapping("/test")
	@ResponseBody
	public Map<String, Object> test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phoneService.getAll());
		return map;
	}

	@PostMapping("/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes redirect) {

		phoneService.delete(id);
		redirect.addFlashAttribute("message", "Xóa thành công điện thoại");
		return "redirect:index";
	}

	@GetMapping("/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		Phone phone = phoneService.get(id);
		DataPhone dataPhone = new DataPhone();
		dataPhone.setPhone(phone);
		dataPhone.setPhoneDetail(phone.getPhoneDetail());
		List<Color> colors = colorService.getAll();
		dataPhone.init(colors);
		dataPhone.init(colors, phone.getPhoneImages());
		model.addAttribute("dataPhone", dataPhone);
		model.addAttribute("phoneTypes", phoneTypeService.getAll());
		model.addAttribute("colors", colors);
		return path + "create";
	}

	@PostMapping("/deleteImages")
	@ResponseBody
	public List<String> deleteImages(@RequestBody List<String> id) {
		for (String string : id) {
			int i = Integer.parseInt(string);
			PhoneImage phoneImage = phoneImageService.get(i);
			phoneImageService.delete(i);
		}
		return id;
	}

}
