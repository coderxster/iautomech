package com.marsapps.iautomech.dao;

import java.util.List;

import com.marsapps.iautomech.domain.Manufacturer;

public interface ManufacturerDAO {

	public Long addManufacturer(Manufacturer manufacturer);
	public List<Manufacturer> getAllManufacturers();
	public Manufacturer findById(Long id);
	public void deleteManufacturer(Long id);
	
}
