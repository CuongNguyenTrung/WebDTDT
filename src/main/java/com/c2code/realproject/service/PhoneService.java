package com.c2code.realproject.service;


import com.c2code.realproject.entity.Phone;

public interface PhoneService extends Service<Phone> {
	public Phone getPhoneBySlugName(String name);
}
