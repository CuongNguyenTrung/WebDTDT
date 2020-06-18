package com.c2code.realproject.dao;

import com.c2code.realproject.entity.Phone;

public interface PhoneDAO<T> extends GenericDAO<T> {

	public Phone getPhoneBySlugName(String name);
}
