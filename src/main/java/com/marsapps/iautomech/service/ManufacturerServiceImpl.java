package com.marsapps.iautomech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marsapps.iautomech.dao.BasicDAO;
import com.marsapps.iautomech.dao.ManufacturerDAO;
import com.marsapps.iautomech.domain.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerDAO manufacturerDAO;

	// Why is a transaction even for a read operation????
	@Transactional
	public List<Manufacturer> getAllManufacturers() {
		// other business logic here
		return manufacturerDAO.getAllManufacturers();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Long addManufacturer(Manufacturer manufacturer) {
		return manufacturerDAO.addManufacturer(manufacturer);
	}

	// Why is a transaction even for a read operation????
	@Transactional
	public Manufacturer findById(Long id) {
		return manufacturerDAO.findById(id);
	}

	@Transactional
	public List<Manufacturer> findByIds(List<Long> ids) {
		return manufacturerDAO.findByIds(ids);
	}
	
	@Transactional
	public List<Manufacturer> findLike(Manufacturer manuf) {
		return manufacturerDAO.findLike(manuf);
	}

	@Transactional
	public void removeManufacturer(Long id) {
		manufacturerDAO.remove(id);
	}

	@Transactional
	public List<Manufacturer> findLike(Manufacturer manuf,
			int numRowsToShow, int pageNum) {
		return manufacturerDAO.findLike(manuf, numRowsToShow, pageNum);
	}
	
	@Transactional
	public Long getManufacturerCount(Manufacturer manuf) {
		return manufacturerDAO.getManufacturerCount(manuf);
	}
	
	@Transactional
	public Long getCount(Manufacturer entity) {
		manufacturerDAO.getCount(entity);
		return null;
	}

	public Long create(Manufacturer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Manufacturer entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
