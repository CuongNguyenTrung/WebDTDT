package com.c2code.realproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.c2code.realproject.entity.Color;


@Repository
public class ColorDAOImpl extends GenericDAOImpl<Color> implements ColorDAO {

	public ColorDAOImpl() {
		clazz = Color.class;
	}

}
