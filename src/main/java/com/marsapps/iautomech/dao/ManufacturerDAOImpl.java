package com.marsapps.iautomech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marsapps.iautomech.domain.Manufacturer;

@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Long addManufacturer(Manufacturer manufacturer) {
		return (Long) getCurrentSession().save(manufacturer);
	}

	public List<Manufacturer> getAllManufacturers() {
		return sessionFactory.getCurrentSession().createQuery("from Manufacturer").list();		
	}

	public Manufacturer findById(Long id) {
		return (Manufacturer) getCurrentSession().get(Manufacturer.class, id);
	}

	public void deleteManufacturer(Long id) {
		
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
