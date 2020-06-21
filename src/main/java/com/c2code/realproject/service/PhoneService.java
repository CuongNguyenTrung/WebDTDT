package com.c2code.realproject.service;


import java.util.List;

import com.c2code.realproject.entity.Phone;

public interface PhoneService extends Service<Phone> {
	public Phone getPhoneBySlugName(String name);
	public List<Phone> getPhoneByNamePhonetype(String name);
	public List<Phone> getPhonesByName(String name);
}
