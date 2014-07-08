package com.marsapps.iautomech.dao;

import java.util.List;

import com.marsapps.iautomech.domain.Part;

public interface PartDAO {

	public Long addPart(Part part);
	
	public Part findById(Long id);

	public List<Part> findPartLike(Part partLike);
	
	
}
