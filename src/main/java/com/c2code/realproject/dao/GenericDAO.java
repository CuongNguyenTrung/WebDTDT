package com.c2code.realproject.dao;

import java.util.List;

public interface GenericDAO<T> {

	List<T> getAll();
	void save(T t);
	void update(T t);
	void delete(int id);
	T get(int id);
}
