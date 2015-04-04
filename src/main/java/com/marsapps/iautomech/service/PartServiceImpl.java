package com.marsapps.iautomech.service;

import java.util.List;

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
	public void update(Part part) {
		partDAO.update(part);
	}

	@Transactional
	public Long addPart(Part part) {
		return partDAO.addPart(part);
	}
	
	@Transactional
	public List<Part> findPartLike(Part partLike) {		
		return partDAO.findPartLike(partLike);
	}

	@Transactional
	public List<Part> findPartLike(Part partLike, int numRowsToShow, int pageNum) {
		return partDAO.findPartLike(partLike, numRowsToShow, pageNum);
	}

	@Transactional
	public Long getCount(Part part) {
		return partDAO.getCount(part);
	}
}
