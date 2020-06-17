package com.c2code.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2code.realproject.dao.ColorDAO;
import com.c2code.realproject.entity.Color;

@Service
public class ColorServiceImpl extends ServiceImpl<Color> implements ColorService {
	
	private ColorDAO colorDAO;
	
	@Autowired
	public ColorServiceImpl(ColorDAO colorDAO) {
		dao = colorDAO;
		this.colorDAO = colorDAO;
	}
}
