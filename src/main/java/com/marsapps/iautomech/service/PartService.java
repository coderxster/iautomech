package com.marsapps.iautomech.service;

import java.util.List;

import com.marsapps.iautomech.domain.Part;

//extract common methods to base interface
public interface PartService {

	public Part findById(Long id);

	public Long addPart(Part part);

	public List<Part> findPartLike(Part partLike);
	
	//refactor method name to findLike 
	public List<Part> findPartLike(Part partLike, int numRowsToShow, int pageNum);
	
	public Long getCount(Part part);
}
