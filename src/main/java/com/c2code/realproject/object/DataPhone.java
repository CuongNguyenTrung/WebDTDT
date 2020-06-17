package com.c2code.realproject.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.c2code.realproject.entity.Color;
import com.c2code.realproject.entity.Phone;
import com.c2code.realproject.entity.PhoneDetail;
import com.c2code.realproject.entity.PhoneImage;

public class DataPhone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Phone phone;

	private PhoneDetail phoneDetail;

	private Map<Integer, List<MultipartFile>> phoneImages = new HashMap<Integer, List<MultipartFile>>();

	private Map<Integer, List<PhoneImage>> stringPhoneImages = new HashMap<Integer, List<PhoneImage>>();

	private Map<Integer, List<MultipartFile>> newPhoneImages = new HashMap<Integer, List<MultipartFile>>();
	
	private MultipartFile image;

	public void init(List<Color> colors) {
		for (Color color : colors) {
			phoneImages.put(color.getId(), null);
			newPhoneImages.put(color.getId(), null);
		}
	}

	public void init(List<Color> colors, List<PhoneImage> phoneImages) {
		for (Color color : colors) {
			List<PhoneImage> list = new ArrayList<>();
			int id = color.getId();
			for (PhoneImage phoneImage : phoneImages) {
				if (phoneImage.getColor().getId() == id)
					list.add(phoneImage);
			}
			if (list.size() != 0)
				this.stringPhoneImages.put(id, list);
			else
				this.stringPhoneImages.put(id, null);
		}
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public PhoneDetail getPhoneDetail() {
		return phoneDetail;
	}

	public void setPhoneDetail(PhoneDetail phoneDetail) {
		this.phoneDetail = phoneDetail;
	}

	public Map<Integer, List<MultipartFile>> getPhoneImages() {
		return phoneImages;
	}

	public void setPhoneImages(Map<Integer, List<MultipartFile>> phoneImages) {
		this.phoneImages = phoneImages;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Map<Integer, List<PhoneImage>> getStringPhoneImages() {
		return stringPhoneImages;
	}

	public void setStringPhoneImages(Map<Integer, List<PhoneImage>> stringPhoneImages) {
		this.stringPhoneImages = stringPhoneImages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<Integer, List<MultipartFile>> getNewPhoneImages() {
		return newPhoneImages;
	}

	public void setNewPhoneImages(Map<Integer, List<MultipartFile>> newPhoneImages) {
		this.newPhoneImages = newPhoneImages;
	}

	
}
