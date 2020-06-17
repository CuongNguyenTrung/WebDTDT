package com.c2code.realproject.dao;

import org.springframework.stereotype.Repository;

import com.c2code.realproject.entity.Phone;

@Repository
public class PhoneDAOImpl extends GenericDAOImpl<Phone> implements PhoneDAO<Phone> {
	
	public PhoneDAOImpl() {
		clazz = Phone.class;
	}
}
