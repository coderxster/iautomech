package com.marsapps.iautomech.dao;

import java.util.List;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.exception.RecordNotFoundException;

public interface ManufacturerDAO {

	public Long addManufacturer(Manufacturer manufacturer);
	public List<Manufacturer> getAllManufacturers();
	public Manufacturer findById(Long id);
	public void deleteManufacturer(Long id) throws RecordNotFoundException;
	public List<Manufacturer> findLike(Manufacturer manuf);
	
}
