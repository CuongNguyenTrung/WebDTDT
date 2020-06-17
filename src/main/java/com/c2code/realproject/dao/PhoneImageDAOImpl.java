package com.c2code.realproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.c2code.realproject.entity.PhoneImage;

@Repository
public class PhoneImageDAOImpl extends GenericDAOImpl<PhoneImage> implements PhoneImageDAO {

	public PhoneImageDAOImpl() {
		clazz = PhoneImage.class;
	}

}
