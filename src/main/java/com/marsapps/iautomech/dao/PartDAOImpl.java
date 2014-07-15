package com.marsapps.iautomech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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

	public List<Part> findPartLike(Part partLike) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Part.class);

		criteria.add(Example.create(partLike).enableLike(MatchMode.ANYWHERE)
				.ignoreCase()
				// we exclude the modifiedDate property given that 'like'
				// doesn't really work with dates
				.excludeProperty("modifiedDate").excludeZeroes());

		if (partLike.getModifiedDate() != null)
			criteria.add(Restrictions.eq("modifiedDate",
					partLike.getModifiedDate()));

		return criteria.list();
	}
}
