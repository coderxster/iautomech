package com.marsapps.iautomech.web.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marsapps.iautomech.domain.Part;
import com.marsapps.iautomech.domain.User;
import com.marsapps.iautomech.service.PartService;

@Controller
@RequestMapping("/rest/inventory/part")
public class PartRESTController {

	@Autowired
	private PartService partService;

	@Transactional
	@ResponseBody
	@RequestMapping(value = "/search/{id}",
			method = RequestMethod.GET, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Part search(@PathVariable String id) {
		Part part = partService.findById(Long.parseLong(id));
		System.err.println("1: " + part.getId());
		System.err.println("2: " + part.getSku());
		System.err.println("3: " + part.getName());
		System.err.println("4: " + part.getQuantity());
		return part;
	}
}
