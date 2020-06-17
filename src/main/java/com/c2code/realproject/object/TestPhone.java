package com.c2code.realproject.object;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.c2code.realproject.entity.Color;
import com.c2code.realproject.entity.Phone;

public class TestPhone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Integer, List<MultipartFile>> file = new HashMap<Integer, List<MultipartFile>>();

	private Phone phone;

	private List<Color> color;

	public void init() {
		for (Color color2 : color) {
			file.put(color2.getId(), null);
		}
	}

	public Map<Integer, List<MultipartFile>> getFile() {
		return file;
	}

	public void setFile(Map<Integer, List<MultipartFile>> file) {
		this.file = file;
	}

	public List<Color> getColor() {
		return color;
	}

	public void setColor(List<Color> color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
