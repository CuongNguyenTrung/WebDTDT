package com.c2code.realproject.service;

import java.util.List;

public interface Service<T> {
	List<T> getAll();

	void save(T t);

	void update(T t);

	void delete(int id);

	T get(int id);
}
