package com.marsapps.iautomech.dao;

import com.marsapps.iautomech.domain.Part;

public interface PartDAO {

	public Long addPart(Part part);
	
	public Part findById(Long id);
	
	
}
