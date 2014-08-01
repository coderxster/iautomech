package com.marsapps.iautomech.service;

import java.util.List;

public interface BasicService<T> {

	public Long create(T entity);
	
	public void update(T entity);
	
	public void delete(Long id);
	
	public List<T> findLike(T likeEntity);
	
	public T findById(Long id);
	
	public List<T> findByIds(List<Long> ids);
	
	public Long getCount(T entity);
}
