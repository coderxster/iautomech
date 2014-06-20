package com.marsapps.iautomech.service;

import java.util.List;

import com.marsapps.iautomech.domain.Manufacturer;

public interface ManufacturerService {

	public List<Manufacturer> getAllManufacturers();
	public Long addManufacturer(Manufacturer manufacturer);
	public Manufacturer findById(Long id);
	public List<Manufacturer> findLike(Manufacturer manuf);
}
