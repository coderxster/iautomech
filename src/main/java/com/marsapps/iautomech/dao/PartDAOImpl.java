package com.marsapps.iautomech.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marsapps.iautomech.domain.Part;

@Repository
public class PartDAOImpl implements PartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Long addPart(Part part) {
		return (Long) sessionFactory.getCurrentSession().save(part);
	}

	public Part findById(Long id) {
		return (Part) sessionFactory.getCurrentSession().load(Part.class, id);
	}

}
