package com.marsapps.iautomech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marsapps.iautomech.dao.PartDAO;
import com.marsapps.iautomech.domain.Part;

@Service
public class PartServiceImpl implements PartService {

	@Autowired
	private PartDAO partDAO;
	
	@Transactional
	public Part findById(Long id) {
		return partDAO.findById(id);
	}

	@Transactional
	public Long addPart(Part part) {
		return partDAO.addPart(part);
	}

}
