package com.marsapps.iautomech.service;

import java.util.List;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.exception.RecordNotFoundException;

public interface ManufacturerService {

	public List<Manufacturer> getAllManufacturers();
	public Long addManufacturer(Manufacturer manufacturer);
	public Manufacturer findById(Long id);
	public List<Manufacturer> findByIds(List<Long> ids);
	public List<Manufacturer> findLike(Manufacturer manuf);
	public void removeManufacturer(Long id);
	public List<Manufacturer> findLike(Manufacturer manuf, int numRowsToShow, int pageNum);
	public Long getManufacturerCount(Manufacturer manuf);
	
}
