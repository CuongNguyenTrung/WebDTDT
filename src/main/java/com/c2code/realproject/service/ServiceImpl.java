package com.c2code.realproject.service;

import java.util.List;

import javax.transaction.Transactional;

import com.c2code.realproject.dao.GenericDAO;

@Transactional
public class ServiceImpl<T> implements Service<T> {

	protected GenericDAO<T> dao;
	
	@Override
	public List<T> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(T t) {
		dao.save(t);
	}

	@Override
	public void update(T t) {
		dao.update(t);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public T get(int id) {
		return dao.get(id);
	}

}
