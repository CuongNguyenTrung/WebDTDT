package com.c2code.realproject.dao;

import java.util.List;

import com.c2code.realproject.entity.Phone;

public interface PhoneDAO<T> extends GenericDAO<T> {

	public Phone getPhoneBySlugName(String name);
	public List<Phone> getPhoneByNamePhonetype(String name);
	public List<Phone> getPhonesByName(String name);
}
