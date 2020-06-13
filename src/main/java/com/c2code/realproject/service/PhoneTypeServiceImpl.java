package com.c2code.realproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2code.realproject.dao.PhoneTypeDAO;
import com.c2code.realproject.entity.PhoneType;

@Service
@Transactional
public class PhoneTypeServiceImpl extends ServiceImpl<PhoneType> implements PhoneTypeService {
	
	private PhoneTypeDAO phoneTypeDAO;
	
	@Autowired
	public PhoneTypeServiceImpl(PhoneTypeDAO phoneTypeDAO) {
		dao = phoneTypeDAO;
		this.phoneTypeDAO = phoneTypeDAO;
	}

}
