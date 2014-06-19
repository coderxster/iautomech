package com.marsapps.iautomech.web.controller;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.service.ManufacturerService;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/springmvc-servlet.xml" })
@WebAppConfiguration
public class ManufacturerControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private ManufacturerService mockService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testShowHome() throws Exception {
		mockMvc.perform(get("/manufacturer/home.html"))
				.andExpect(view().name("manufacturer/home"));
	}
	
	@Test
	public void testListManufacturer() throws Exception {

		Manufacturer manuf1 = new Manufacturer();
		manuf1.setId(1L);
		manuf1.setName("Zama");
		manuf1.setContactName("SomeName");
		manuf1.setContactNumber("555-123");

		Manufacturer manuf2 = new Manufacturer();
		manuf2.setId(2L);
		manuf2.setName("Walbro");
		manuf2.setContactName("SomeOtherName");
		manuf2.setContactNumber("123-555");

//		when(mockService.getAllManufacturers()).thenReturn(
//				Arrays.asList(manuf1, manuf2));

		mockMvc.perform(post("/manufacturer/listAll.html"))
				.andExpect(status().isOk())
				.andExpect(view().name("manufacturer/home"));
//				.andExpect(model().attribute("manufList", ));

	}
}
