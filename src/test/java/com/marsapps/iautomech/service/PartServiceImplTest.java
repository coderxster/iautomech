package com.marsapps.iautomech.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.domain.Part;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/service-context.xml")
@Transactional
@TransactionConfiguration
public class PartServiceImplTest {

	@Autowired
	private PartService partService;
	
	@Autowired
	private ManufacturerService manufService;
	
	@Test
	public void createPart() {
		Part part = new Part();
		part.setName("Washer Kit");
		part.setPartNo("X123");
		part.setSku("SKU222333");
		part.setModelNo("A5436");
		part.setQuantity(500L);
		part.setDescription("This is my Part's description");
		
		Manufacturer manuf = new Manufacturer("Walbro","Mars", "555 123 321");
		
		manufService.addManufacturer(manuf);
		part.setManufacturer(manuf);		
		
		Long id = partService.addPart(part);
		
		assertTrue(id > 0);
		
		Part fetchedPart = partService.findById(id);
		assertEquals((long) part.getQuantity(), (long) fetchedPart.getQuantity());
		assertEquals(part.getPartNo(), fetchedPart.getPartNo());
		assertEquals(part.getManufacturer().getName(), fetchedPart.getManufacturer().getName());
	}
	
	@Test
	public void testFindById() {
		Manufacturer manuf = new Manufacturer();
		manuf.setName("Zama");
		manuf.setContactName("John Doe");
		manuf.setContactNumber("555-123456");
	
		Long manufId = manufService.addManufacturer(manuf);
		assertTrue(manufId > 0);
		
		Part part = new Part();
		part.setManufacturer(manuf);
		part.setModifiedDate(new Date(new java.util.Date().getTime()));
		part.setName("RandomNameHere");
		part.setSku("GeneratedSkuHere");
		
		Long partId = partService.addPart(part);
				
		assertTrue(partId > 0);
		part.setId(partId);
				
		Part fetchedPart = partService.findById(partId);
		
		assertEquals(part, fetchedPart);
		assertEquals(part.getManufacturer(), fetchedPart.getManufacturer());
		
		assertEquals("Zama", fetchedPart.getManufacturer().getName());
	}
	
	@Test
	public void testFindPartLike() {
		Manufacturer manuf = new Manufacturer();
		manuf.setName("Zama");
		manuf.setContactName("John Doe");
		manuf.setContactNumber("555-123456");
		
		manufService.addManufacturer(manuf);
		
		Part part1 = new Part();
		part1.setManufacturer(manuf);
		part1.setModifiedDate(new Date(new java.util.Date().getTime()));
		part1.setName("RandomNameHere");
		part1.setSku("GeneratedSkuHere");
		
		Part part2 = new Part();
		part2.setManufacturer(manuf);
		part2.setModifiedDate(new Date(new java.util.Date().getTime()));
		part2.setName("mNamer");
		part2.setSku("mySkuRules");
		
		partService.addPart(part1);
		partService.addPart(part2);
		
		//use a different part object with similar values
		Part partLike = new Part();
		partLike.setName("mname");
		partLike.setSku("sku");
		
		List<Part> fetchedPartList = partService.findPartLike(partLike);
		
		assertEquals(2, fetchedPartList.size());
		
		for(Part part : fetchedPartList) {
			assertEquals(manuf.getName(), part.getManufacturer().getName());
		}
		
		
	}

}
