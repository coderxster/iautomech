package com.marsapps.iautomech.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

		// manuf = null;
		// manuf = new Manufacturer();
		// manuf.setId(id);
		// manuf.setName("test");
		// manuf.setContactName("Me");
		// manuf.setContactNumber("321");

		Manufacturer fetchedManuf = service.findById(id);
		System.err.println("1....: " + manuf);
		System.err.println("2....: " + fetchedManuf);

		assertEquals(fetchedManuf, manuf);
	}

	@Test
	public void removeManufacturer() {
		Manufacturer manuf1 = new Manufacturer();
		manuf1.setName("Walbro");
		manuf1.setContactName("Marcelo");

		long id = service.addManufacturer(manuf1);
		assertTrue(id > 1);

		service.removeManufacturer(id);

		Manufacturer manuf2 = service.findById(id);
		assertNull(manuf2);
	}

	@Test
	public void testFindByIds() {
		
		List<Long> ids = new ArrayList<Long>();
		
		for (int i = 0; i < 5; i++) {
			Manufacturer manuf1 = new Manufacturer();
			manuf1.setName("Walbro-" + i);
			manuf1.setContactName("Marcelo-" + i);
			manuf1.setContactNumber("555-" + i);

			ids.add(service.addManufacturer(manuf1));
		}
		
		List<Manufacturer> fetchedManufacturers = service.findByIds(ids);
		
		for(Manufacturer manuf : fetchedManufacturers) {
			assertTrue(ids.contains(manuf.getId()));
		}
	}
	
	@Test
	public void testFindManufacturer() {
		Manufacturer manuf1 = new Manufacturer();
		manuf1.setName("TmpWalbro");
		manuf1.setContactName("Marcelo");

		Manufacturer manuf2 = new Manufacturer();
		manuf2.setName("MarsTmpWalbro");
		manuf2.setContactName("Carcelis");

		long id1 = service.addManufacturer(manuf1);
		long id2 = service.addManufacturer(manuf2);

		Manufacturer manufTmp = service.findById(id1);
		assertEquals(manuf1, manufTmp);
		
		System.err.println(id1);
		System.err.println(id2);

		Manufacturer manufLike = new Manufacturer();
		manufLike.setName("TmpW");
		manufLike.setContactName("arcel");

		
		List<Manufacturer> list = service.findLike(manufLike);
		assertEquals(2, list.size());
	}

	@Test
	public void testPaging() {

		for (int i = 0; i < 20; i++) {
			Manufacturer manuf1 = new Manufacturer();
			manuf1.setName("TestName-" + i);
			manuf1.setContactName("TestContactName-" + i);
			manuf1.setContactNumber("555-" + i);

			service.addManufacturer(manuf1);
		}

		Manufacturer manufLike = new Manufacturer();
		manufLike.setName("tna");
		manufLike.setContactName("tact");

		int numRowsToShow = 5;
		int pageNum = 3;
		
		List<Manufacturer> list = service.findLike(manufLike, numRowsToShow, pageNum);

		assertNotNull(list);
		assertEquals(5, list.size());
		
		int counter = (numRowsToShow * pageNum) - numRowsToShow;
		for (int i = 0; i < list.size(); i++, counter++) {
			assertEquals("TestName-" + counter, list.get(i).getName());
			assertEquals("TestContactName-" + counter, list.get(i).getContactName());
			assertEquals("555-" + counter, list.get(i).getContactNumber());
		}

	}
}
