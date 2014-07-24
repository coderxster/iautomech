package com.marsapps.iautomech.dao;

import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.domain.Part;


public class AbstractBaseDAO<T> implements BasicDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;
		
	public List<T> findLike(T entity, int numRowsToShow,
			int pageNum) {

		/*** Can this be done with NamedQueries?? ***/

		Example example = Example.create(entity).enableLike(MatchMode.ANYWHERE)
				.ignoreCase().excludeZeroes();

		Criteria criteria = getCurrentSession().createCriteria(
				entity.getClass()).add(example);

		if (numRowsToShow > 0 && pageNum > 0) {
			criteria.setFirstResult((numRowsToShow * pageNum) - numRowsToShow);
			criteria.setMaxResults(numRowsToShow);
		}

		return criteria.list();
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Long create(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public List<T> findLike(T likeEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<T> findByIds(List<Long> ids) {
		Type[] s = this.getClass().getGenericInterfaces();
		System.err.println("OOKKKKKKKKKKKK1111111 +++++");
		for(Type t : s) {
			System.err.println("type: " + t.getClass());
		}
		
		return getCurrentSession().createCriteria(Manufacturer.class)
				.add(Restrictions.in("id", ids)).list();
	}

	public T findById(Long id) {
		Type[] s = this.getClass().getGenericInterfaces();
		System.err.println("OOKKKKKKKKKKKK +++++");
		for(Type t : s) {
			System.err.println("type: " + t.getClass());
		}
		
		return null;
	}
	
}
