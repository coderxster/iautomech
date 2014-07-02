package com.marsapps.iautomech.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.service.ManufacturerService;

@Controller
@RequestMapping("/manufacturer")
@SessionAttributes("manufacturer")
public class ManufacturerController {

	@Autowired
	private ManufacturerService service;

	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		Manufacturer manuf = new Manufacturer();
		model.put("manufacturer", manuf);

		return "manufacturer/home";
	}

	@RequestMapping(value = "/createForm.html", method = RequestMethod.GET)
	public String showCreateForm(ModelMap model) {
		return "manufacturer/createManufacturer";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(
			@ModelAttribute("manufacturer") Manufacturer manufacturer,
			ModelMap model) {

		service.addManufacturer(manufacturer);
		List<Manufacturer> list = service.getAllManufacturers();
		System.err.println(list);
		model.put("manufacturerList", list);

		return "manufacturer/listManufacturers";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id, ModelMap model) {
		service.removeManufacturer(Long.parseLong(id));
		List<Manufacturer> list = service.getAllManufacturers();
		model.put("manufacturerList", list);
		return "manufacturer/listManufacturers";
	}

	@RequestMapping(value = "/searchForm.html", method = RequestMethod.GET)
	public String showSearchForm(ModelMap model) {
		model.put("manufacturer", new Manufacturer());
		return "manufacturer/searchManufacturer";
	}

	@RequestMapping(value = "/search.html", method = RequestMethod.POST)
	public String search(@ModelAttribute("manufacturer") Manufacturer manuf,
			ModelMap model, BindingResult result) {
		if (result.hasErrors())
			throw new RuntimeException();

		List<Manufacturer> list = service.findLike(manuf, 20, 1);
		model.put("manufacturerList", list);
		
		Long count = service.getManufacturerCount(manuf);

		StringBuilder query = new StringBuilder();
		query.append("name=" + manuf.getName());
		query.append("&contactname=" + manuf.getContactName());
		query.append("&contactnumber=" + manuf.getContactNumber());
		model.put("query", query.toString());
		model.put("page", 1);
		model.put("maxpage", ((long) count / 20) == 0 ? 1 : (long) count / 20);
		
		return "manufacturer/searchManufacturer";
	}

	@RequestMapping("/listAll.html")
	public String listManufacturers(Model model, HttpSession session) {
		List<Manufacturer> list = service.getAllManufacturers();
		session.setAttribute("manufacturerList", list);
		return "manufacturer/listManufacturers";
	}
	
	@RequestMapping("/doPaging.html")
	public String navigate(@RequestParam("name") String name,
			@RequestParam("contactname") String contactName,
			@RequestParam("contactnumber") String contactNumber,
			@RequestParam("page") String page,
			ModelMap model) {

		Manufacturer manuf = new Manufacturer();
		manuf.setName(name);
		manuf.setContactName(contactName);
		manuf.setContactNumber(contactNumber);
		
		
		List<Manufacturer> list = service.findLike(manuf, 20, Integer.parseInt(page));
		model.put("manufacturerList", list);
		
		Long count = service.getManufacturerCount(manuf);
			
		StringBuilder query = new StringBuilder();
		query.append("name=" + manuf.getName());
		query.append("&contactname=" + manuf.getContactName());
		query.append("&contactnumber=" + manuf.getContactNumber());
		model.put("query", query.toString());
		model.put("page", page);
		model.put("maxpage", ((long) count / 20) == 0 ? 1 : (long) count / 20);
		
		
		return "manufacturer/searchManufacturer";
	}
}
