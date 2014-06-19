package com.marsapps.iautomech.service;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.marsapps.iautomech.domain.Manufacturer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/springmvc-servlet.xml" })
@WebAppConfiguration
@TransactionConfiguration
@Transactional
public class ManufacturerServiceImplTest {

	@Autowired
	private ManufacturerService service;

	@Before
	public void setup() {

	}

	@Test
	public void testGetAllManufacturers() {
		List<Manufacturer> list = service.getAllManufacturers();
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testAddManufacturer() {
		/****
		 * UNDERSTAND WHY manuf and fetchedManuf are THE SAME object (both have
		 * same toString value)
		 ****/
		Manufacturer manuf = new Manufacturer();
		manuf.setName("Walbro-Junit");
		manuf.setContactName("Me");
		manuf.setContactNumber("321");

		Long id = service.addManufacturer(manuf);
		manuf.setId(id);

//		manuf = null;
//		manuf = new Manufacturer();
//		manuf.setId(id);
//		manuf.setName("test");
//		manuf.setContactName("Me");
//		manuf.setContactNumber("321");

		Manufacturer fetchedManuf = service.findById(id);
		System.err.println("1....: " + manuf);
		System.err.println("2....: " + fetchedManuf);

		assertEquals(fetchedManuf, manuf);
	}

}
