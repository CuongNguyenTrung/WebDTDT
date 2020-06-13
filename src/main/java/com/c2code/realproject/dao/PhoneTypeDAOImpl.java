package com.c2code.realproject.dao;

import org.springframework.stereotype.Repository;

import com.c2code.realproject.entity.PhoneType;

@Repository
public class PhoneTypeDAOImpl extends GenericDAOImpl<PhoneType> implements PhoneTypeDAO {

	public PhoneTypeDAOImpl() {
		clazz = PhoneType.class;
	}
}
