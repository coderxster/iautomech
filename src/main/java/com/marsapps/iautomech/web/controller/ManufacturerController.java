package com.marsapps.iautomech.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.service.ManufacturerService;

@Controller
@RequestMapping("/inventory/manufacturer")
@SessionAttributes("manufacturer")
public class ManufacturerController extends
		AbstractBaseController<Manufacturer> {

	@Autowired
	private ManufacturerService service;

	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		Manufacturer manuf = new Manufacturer();
		model.put("manufacturer", manuf);

		return "inventory/manufacturer/home";
	}

	@RequestMapping(value = "/createForm.html", method = RequestMethod.GET)
	public String showCreateForm(ModelMap model) {
		return "inventory/manufacturer/createManufacturer";
	}

	@RequestMapping(value = "/create.html", method = RequestMethod.POST)
	public String create(
			@ModelAttribute("manufacturer") Manufacturer manufacturer,
			ModelMap model) {

		service.addManufacturer(manufacturer);
		List<Manufacturer> list = service.getAllManufacturers();
		System.err.println(list);
		model.put("manufacturerList", list);

		return "inventory/manufacturer/listManufacturers";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id, ModelMap model) {
		service.removeManufacturer(Long.parseLong(id));
		List<Manufacturer> list = service.getAllManufacturers();
		model.put("manufacturerList", list);
		return "inventory/manufacturer/listManufacturers";
	}

	@RequestMapping(value = "/searchForm.html", method = RequestMethod.GET)
	public String showSearchForm(ModelMap model) {
		model.put("manufacturer", new Manufacturer());
		return "inventory/manufacturer/searchManufacturer";
	}

	@RequestMapping(value = "/search.html", method = RequestMethod.POST)
	public String search(@ModelAttribute("manufacturer") Manufacturer manuf,
			@RequestParam("rowsPerPage") String rowsPerPage, ModelMap model,
			BindingResult result, HttpSession session) {
		
		if (result.hasErrors())
			throw new RuntimeException();

		int rows = Integer.parseInt(rowsPerPage);
		session.setAttribute("rowsPerPage", rows);

		List<Manufacturer> list = service.findLike(manuf, rows, 1);
		model.put("manufacturerList", list);

		Long count = service.getManufacturerCount(manuf);

		StringBuilder query = new StringBuilder();
		query.append("name=" + manuf.getName());
		query.append("&contactname=" + manuf.getContactName());
		query.append("&contactnumber=" + manuf.getContactNumber());
		model.put("query", query.toString());
		model.put("page", 1);
		model.put("maxpage", ((long) count / rows) == 0 ? 1 : (long) count
				/ rows);

		return "inventory/manufacturer/searchManufacturer";
	}

	@RequestMapping("/listAll.html")
	public String listManufacturers(Model model, HttpSession session) {
		List<Manufacturer> list = service.getAllManufacturers();
		session.setAttribute("manufacturerList", list);
		return "inventory/manufacturer/listManufacturers";
	}

	@RequestMapping("/doPaging.html")
	public String navigate(@RequestParam("name") String name,
			@RequestParam("contactname") String contactName,
			@RequestParam("contactnumber") String contactNumber,
			@RequestParam("page") String page, ModelMap model,
			HttpSession session, @ModelAttribute Manufacturer modelType) {
				
		System.err.println("=====LETS 00000000000 SEE+++");
		int rows = (Integer) session.getAttribute("rowsPerPage");

		Manufacturer manuf = new Manufacturer();
		manuf.setName(name);
		manuf.setContactName(contactName);
		manuf.setContactNumber(contactNumber);

		List<Manufacturer> list = service.findLike(manuf, rows,
				Integer.parseInt(page));
		model.put("manufacturerList", list);
		Long count = service.getManufacturerCount(manuf);

		StringBuilder query = new StringBuilder();
		query.append("name=" + manuf.getName());
		query.append("&contactname=" + manuf.getContactName());
		query.append("&contactnumber=" + manuf.getContactNumber());
		model.put("query", query.toString());
		model.put("page", page);
		model.put("maxpage", ((long) count / rows) == 0 ? 1 : (long) count
				/ rows);

		return "inventory/manufacturer/searchManufacturer";
	}

	@RequestMapping("/delete.html")
	public String deleteManufacturers(ModelMap model, HttpSession session,
			@RequestParam("selectedIds") String[] ids) {
		List<Long> idList = new ArrayList<Long>();

		for (String id : ids)
			idList.add(Long.parseLong(id));

		List<Manufacturer> list = service.findByIds(idList);
		session.setAttribute("manufacturersToDelete", list);

		return "inventory/manufacturer/confirmDelete";
	}

	@RequestMapping("/deleteConfirmed.html")
	public String deleteManufacturers(ModelMap model, HttpSession session) {
		// delete by ids

		// looks like this is null
		List<Manufacturer> list = (List<Manufacturer>) session
				.getAttribute("manufacturersToDelete");

		for (Manufacturer manuf : list) {
			// make this a bulk delete to avoid round trips to DB
			service.removeManufacturer(manuf.getId());
		}

		model.put("message", "Manufacturers deleted successfully");

		return "inventory/manufacturer/searchManufacturer";
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handleException(ConstraintViolationException ex) {
		ModelAndView model = new ModelAndView("error/error");
		model.addObject("exception", ex);
		
		return model;
	}
	
}