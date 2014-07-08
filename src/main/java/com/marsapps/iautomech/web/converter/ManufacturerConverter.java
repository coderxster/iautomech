package com.marsapps.iautomech.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.service.ManufacturerService;

@Component
public class ManufacturerConverter implements Converter<String, Manufacturer> {
	
	@Autowired
	private ManufacturerService service;
	
	public Manufacturer convert(String source) {
		System.err.println("WE GOT THIS --->>>>>>>> " + source);
		return service.findById(Long.parseLong(source));
	}
	
}
