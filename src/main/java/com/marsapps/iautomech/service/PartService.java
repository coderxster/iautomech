package com.marsapps.iautomech.service;

import com.marsapps.iautomech.domain.Part;

public interface PartService {

	public Part findById(Long id);

	public Long addPart(Part part);
	
}
