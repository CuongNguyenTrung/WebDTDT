package com.c2code.realproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2code.realproject.dao.PhoneDAO;
import com.c2code.realproject.entity.Phone;

@Service
public class PhoneServiceImpl extends ServiceImpl<Phone> implements PhoneService {

	private PhoneDAO phoneDAO;

	@Autowired
	public PhoneServiceImpl(PhoneDAO phoneDAO) {
		dao = phoneDAO;
		this.phoneDAO = phoneDAO;
	}

	@Override
	public Phone getPhoneBySlugName(String name) {
		return phoneDAO.getPhoneBySlugName(name);
	}

	@Override
	public List<Phone> getPhoneByNamePhonetype(String name) {
		return phoneDAO.getPhoneByNamePhonetype(name);
	}

	@Override
	public List<Phone> getPhonesByName(String name) {
		return phoneDAO.getPhonesByName(name);
	}
}
