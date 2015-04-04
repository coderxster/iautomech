package com.marsapps.iautomech.dao;

import java.util.List;

import com.marsapps.iautomech.domain.Part;

public interface PartDAO extends BasicDAO<Part> {

	public Long addPart(Part part);
	
	public void update(Part part);
	
	public Part findById(Long id);

	public List<Part> findPartLike(Part partLike);
	
	public List<Part> findPartLike(Part partLike, int numRowsToShow, int pageNum);
	
	
}
