package com.marsapps.iautomech.dao;

import java.util.List;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.exception.RecordNotFoundException;

public interface ManufacturerDAO extends BasicDAO<Manufacturer> {

	public Long addManufacturer(Manufacturer manufacturer);
	public List<Manufacturer> getAllManufacturers();	
	public Manufacturer findById(Long id);
	public List<Manufacturer> findByIds(List<Long> ids);
	public void deleteManufacturer(Long id) throws RecordNotFoundException;
	public List<Manufacturer> findLike(Manufacturer manuf);
	public void remove(Long id);
	public List<Manufacturer> findLike(Manufacturer manuf, int numRowsToShow, int pageNum);
	public Long getManufacturerCount(Manufacturer manuf);
}
