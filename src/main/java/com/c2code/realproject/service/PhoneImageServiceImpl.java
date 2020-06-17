package com.c2code.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2code.realproject.dao.PhoneImageDAO;
import com.c2code.realproject.entity.PhoneImage;

@Service
public class PhoneImageServiceImpl extends ServiceImpl<PhoneImage> implements PhoneImageService {

	private PhoneImageDAO phoneImageDAO;
	
	@Autowired
	public PhoneImageServiceImpl(PhoneImageDAO phoneImageDAO) {
		dao = phoneImageDAO;
		this.phoneImageDAO = phoneImageDAO;
	}

}
