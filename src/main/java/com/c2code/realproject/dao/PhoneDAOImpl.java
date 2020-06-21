package com.c2code.realproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.c2code.realproject.entity.Phone;

@Repository
public class PhoneDAOImpl extends GenericDAOImpl<Phone> implements PhoneDAO<Phone> {

	public PhoneDAOImpl() {
		clazz = Phone.class;
	}

	@Override
	public Phone getPhoneBySlugName(String name) {
		name = name.replace("-", " ");
		Session session = createSession();
		Phone phone = session.createQuery("select p from Phone p where lower(name) = :name", Phone.class)
				.setParameter("name", name).getSingleResult();
		return phone;
	}

	@Override
	public List<Phone> getPhoneByNamePhonetype(String name) {
		Session session = createSession();
		List<Phone> phones = session
				.createQuery("select p from Phone p join p.type type where lower(type.name) = :name", Phone.class)
				.setParameter("name", name).list();
		return phones;
	}

	@Override
	public List<Phone> getPhonesByName(String name) {
		Session session = createSession();
		List<Phone> phones = session.createQuery("from Phone p where lower(name) LIKE :name", Phone.class)
				.setParameter("name", "%" + name.toLowerCase() + "%")
				.list();
		return phones;
	}
}
