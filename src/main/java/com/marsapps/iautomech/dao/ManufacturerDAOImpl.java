package com.marsapps.iautomech.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.exception.RecordNotFoundException;

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

	public void deleteManufacturer(Long id) throws RecordNotFoundException {
		Manufacturer manuf = findById(id);
		
		if(manuf != null) 
			getCurrentSession().delete(manuf);
		else
			throw new RecordNotFoundException("Manufacturer with ID: " + id + " was not found");
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Manufacturer> findLike(Manufacturer manuf) {
		StringBuilder hql = new StringBuilder("from Manufacturer where ");
		
		if(manuf.getName() != null && !manuf.getName().equals(""))
			hql.append(" lower(name) like lower(:name) and ");		
		if(manuf.getContactName() != null && !manuf.getContactName().equals("")) 
			hql.append(" lower(contactName) like lower(:contactName) and ");
		if(manuf.getContactNumber() != null && !manuf.getContactNumber().equals(""))
			hql.append(" lower(contactNumber) like lower(:contactNumber) and ");		
		
		hql.delete(hql.length() - 5, hql.length());
		Query query = getCurrentSession().createQuery(hql.toString());
		
		if(manuf.getName() != null && !manuf.getName().equals(""))
			query.setParameter("name", "%" + manuf.getName() + "%");		
		if(manuf.getContactName() != null && !manuf.getContactName().equals(""))
			query.setParameter("contactName", "%" + manuf.getContactName() + "%");
		if(manuf.getContactNumber() != null && !manuf.getContactNumber().equals(""))
			query.setParameter("contactNumber", "%" + manuf.getContactNumber() + "%");
		
		System.err.println("HQL");
				
		return query.list();
	}
	
	public void remove(Long id) {
		Session session = getCurrentSession();
		session.delete(session.load(Manufacturer.class,id));
	}
}
