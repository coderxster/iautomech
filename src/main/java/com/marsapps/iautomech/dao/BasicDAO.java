package com.marsapps.iautomech.dao;

import java.util.List;

import com.marsapps.iautomech.domain.Manufacturer;

public interface BasicDAO<T> {

	public Long create(T entity);
	
	public void update(T entity);
	
	public void delete(Long id);
	
	public List<T> findLike(T likeEntity);
	
	public T findById(Long id);
	
	public List<T> findByIds(List<Long> ids);
}