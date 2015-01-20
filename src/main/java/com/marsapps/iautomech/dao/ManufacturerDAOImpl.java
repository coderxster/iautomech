package com.marsapps.iautomech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.exception.RecordNotFoundException;

@Repository
public class ManufacturerDAOImpl extends AbstractBaseDAO<Manufacturer>
		implements ManufacturerDAO {

	public Long addManufacturer(Manufacturer manufacturer) {
		return (Long) getCurrentSession().save(manufacturer);
	}

	public List<Manufacturer> getAllManufacturers() {
		return getCurrentSession().createQuery("from Manufacturer").list();
	}

	public Manufacturer findById(Long id) {
		return (Manufacturer) getCurrentSession().get(Manufacturer.class, id);
	}

	public void deleteManufacturer(Long id) throws RecordNotFoundException {
		Manufacturer manuf = findById(id);

		if (manuf != null)
			getCurrentSession().delete(manuf);
		else
			throw new RecordNotFoundException("Manufacturer with ID: " + id
					+ " was not found");
	}

	public List findLike(Manufacturer entity, int numRowsToShow,
			int pageNum) {

		/*** Can this be done with a NamedQuery?? ***/

		Example example = Example.create(entity)
				.enableLike(MatchMode.ANYWHERE)
				.ignoreCase()
				.excludeZeroes();

		Criteria criteria = getCurrentSession()
				.createCriteria(entity.getClass()).add(example);

		if (numRowsToShow > 0 && pageNum > 0) {
			criteria.setFirstResult((numRowsToShow * pageNum) - numRowsToShow);
			criteria.setMaxResults(numRowsToShow);
			//why was the below line here??
			//criteria.setProjection(Projections.rowCount());
		}

		return criteria.list();
	}
	
	public List<Manufacturer> findLike(Manufacturer manuf) {
		return findLike(manuf, 0, 0);
	}

	public void remove(Long id) {
		Session session = getCurrentSession();
		session.delete(session.load(Manufacturer.class, id));
	}

	public Long getManufacturerCount(Manufacturer manuf) {
		Example example = Example.create(manuf).enableLike(MatchMode.ANYWHERE)
				.ignoreCase().excludeZeroes();

		Criteria criteria = getCurrentSession()
				.createCriteria(Manufacturer.class).add(example)
				.setProjection(Projections.rowCount());

		return (Long) criteria.uniqueResult();
	}

}
