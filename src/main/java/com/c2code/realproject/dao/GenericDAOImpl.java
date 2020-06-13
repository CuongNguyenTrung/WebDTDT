package com.c2code.realproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class GenericDAOImpl<T> implements GenericDAO<T> {

	@Autowired
	protected SessionFactory factory;
	protected Class<T> clazz;

	protected Session createSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<T> getAll() {
		Session session = createSession();
		List<T> list = session.createQuery("from " + clazz.getName()).list();
		return list;
	}

	@Override
	public void save(T t) {
		Session session = createSession();
		session.persist(t);
	}

	@Override
	public void update(T t) {
		Session session = createSession();
		session.update(t);
	}

	@Override
	public void delete(int id) {
		Session session = createSession();
		T t = session.get(clazz, id);
		if(t != null) session.delete(t);
	}

	@Override
	public T get(int id) {
		Session session = createSession();
		return session.get(clazz, id);
	}

}
