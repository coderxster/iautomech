package com.marsapps.iautomech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marsapps.iautomech.dao.ManufacturerDAO;
import com.marsapps.iautomech.domain.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerDAO manufacturerDAO;
	
	//Why is a transaction even for a read operation???? 
	@Transactional
	public List<Manufacturer> getAllManufacturers() {
		//other business logic here
		return manufacturerDAO.getAllManufacturers();		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Long addManufacturer(Manufacturer manufacturer) {
		return manufacturerDAO.addManufacturer(manufacturer);
	}

	//Why is a transaction even for a read operation???? 
	@Transactional
	public Manufacturer findById(Long id) {
		return manufacturerDAO.findById(id);
	}
}
