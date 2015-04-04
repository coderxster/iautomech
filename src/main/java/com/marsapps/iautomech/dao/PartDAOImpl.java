package com.marsapps.iautomech.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marsapps.iautomech.domain.Part;

@Repository
public class PartDAOImpl extends AbstractBaseDAO<Part> implements PartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(PartDAOImpl.class);

	public Long addPart(Part part) {
		return (Long) sessionFactory.getCurrentSession().save(part);
	}

	public Part findById(Long id) {
		return (Part) sessionFactory.getCurrentSession().load(Part.class, id);
	}

	public List<Part> findPartLike(Part partLike) {
		return findPartLike(partLike, 0, 0);
	}

	public void update(Part part) {
		sessionFactory.getCurrentSession().update(part);
	}
	
	public List<Part> findPartLike(Part partLike, int numRowsToShow, int pageNum) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Part.class);


		criteria.add(Example.create(partLike)
				.enableLike(MatchMode.ANYWHERE)
				.ignoreCase()
				.excludeZeroes()
				//provide a custom Property selector to ignore empty Strings - POSSIBLY EXTRACT THIS INTO A UTIL CLASS/PACKAGE??
				.setPropertySelector(new Example.PropertySelector() {
					
					public boolean include(Object propertyValue, String propertyName, Type type) {
						if(propertyValue == null || (propertyValue instanceof String && propertyValue.equals("")))
							return false;
						
						return true;
					}
				})
				// we exclude the modifiedDate property given that 'like'
				// doesn't really work with dates
				.excludeProperty("modifiedDate")
				.excludeProperty("id"));

		if (partLike.getManufacturer() != null)
			criteria.add(Restrictions.eq("manufacturer",
					partLike.getManufacturer()));

		if (partLike.getId() != null && partLike.getId() > 0)
			criteria.add(Restrictions.eq("id", partLike.getId()));

		if (partLike.getModifiedDate() != null) {
			Date minDate = partLike.getModifiedDate();

			// add one day to the given date property
			Calendar cal = Calendar.getInstance();
			cal.setTime(partLike.getModifiedDate());
			cal.add(Calendar.DAY_OF_MONTH, 1);

			// then use that as the max date
			Date maxDate = cal.getTime();

			Disjunction or = Restrictions.disjunction();
			or.add(Restrictions.gt("modifiedDate", minDate)).add(
					Restrictions.eq("modifiedDate", minDate));

			criteria.add(or).add(Restrictions.lt("modifiedDate", maxDate));
		}
		
		if (numRowsToShow > 0 && pageNum > 0) {
			criteria.setFirstResult((numRowsToShow * pageNum) - numRowsToShow);
			criteria.setMaxResults(numRowsToShow);
			//why was the below line here??
			//criteria.setProjection(Projections.rowCount());
		}

		return criteria.list();
	}
	
	
}
