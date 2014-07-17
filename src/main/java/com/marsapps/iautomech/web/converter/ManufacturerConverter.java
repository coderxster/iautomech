package com.marsapps.iautomech.web.converter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.service.ManufacturerService;

/**
 * This class is used by Spring when a conversion between a String to a
 * Manufacturer is needed.
 * 
 * @author ortegm
 * 
 */
@Component
public class ManufacturerConverter implements Converter<String, Manufacturer> {

	@Autowired
	private ManufacturerService service;

	private Logger log = Logger.getLogger(ManufacturerConverter.class); 
	/**
	 * Converts the given source (an ID which represents a Manufacturer) to Manufacturer
	 * @return a Manufacturer object
	 */
	public Manufacturer convert(String source) {
		long id = -1;
		try {
			log.debug("ManufacturerConverter called to convert " + source + " to a Manufacturer");
			id = Long.parseLong(source);
		} catch (NumberFormatException nfe) {
			System.err.println("Could not convert '" + source
					+ "' to a Manufactuer - it's not a valid ID: "
					+ nfe.getMessage());
		}

		return (id != -1) ? service.findById(id) : null;
	}

}