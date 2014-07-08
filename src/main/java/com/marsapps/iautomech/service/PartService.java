package com.marsapps.iautomech.service;

import java.util.List;

import com.marsapps.iautomech.domain.Part;

public interface PartService {

	public Part findById(Long id);

	public Long addPart(Part part);

	public List<Part> findPartLike(Part partLike);
	
}
