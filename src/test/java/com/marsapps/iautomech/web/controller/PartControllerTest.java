package com.marsapps.iautomech.web.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.marsapps.iautomech.domain.Part;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@WebAppConfiguration
public class PartControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testShowHomePage() throws Exception {
		mockMvc.perform(get("/part/home.html")).andExpect(
				view().name("part/home"));
	}

	@Test
	public void testSearchPartPage() throws Exception {
		mockMvc.perform(get("/part/searchForm.html"))
				.andExpect(view().name("part/searchPart"));
	}
	
	@Test
	public void testPartAttributeBinding() throws Exception {
		Part part = new Part();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		part.setModifiedDate(new Date(dateFormat.parse("07/07/2014 11:35:1").getTime()));
		
//		MockHttpServletRequest mockRequest = new MockHttpServletRequest("post","/part/search.html");
//		mockRequest.setAttribute("part", part);
//		
//		SimpleRequestBuilder builder = new SimpleRequestBuilder(mockRequest);
//		
//		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/part/search.html");
//		reqBuilder.
		
		mockMvc.perform(get("/part/search.html").requestAttr("part", part))
				.andExpect(view().name("part/searchPart"));
	}
}



















