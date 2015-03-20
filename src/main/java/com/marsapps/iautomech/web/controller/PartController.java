package com.marsapps.iautomech.web.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.domain.Part;
import com.marsapps.iautomech.service.ManufacturerService;
import com.marsapps.iautomech.service.PartService;
import com.marsapps.iautomech.web.converter.ManufacturerPropertyEditor;

@Controller
@RequestMapping("/inventory/part")
@SessionAttributes("manufacturerList")
public class PartController {

	@Autowired
	private PartService partService;

	@Autowired
	private ManufacturerService manufService;

	@RequestMapping(value = { "/", "/home" })
	public String showHomePage() {
		return "inventory/part/home";
	}

	@RequestMapping("searchForm.html")
	public String showSearchForm(Model model) {
		model.addAttribute("part", new Part());
		model.addAttribute("manufacturerList",
				manufService.getAllManufacturers());
		return "inventory/part/searchPart";
	}

	@RequestMapping("/createForm.html")
	public ModelAndView showCreatePartForm() {
		ModelAndView mav = new ModelAndView("inventory/part/createPart");

		Part part = new Part();
		mav.addObject("part", part);
		mav.addObject("manufacturerList", manufService.getAllManufacturers());

		return mav;
	}

	@RequestMapping("create.html")
	public String create(@Valid @ModelAttribute("part") Part part,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			// if there are any validation errors, then don't proceed, just
			// return to the view to render the validation errors
			return "inventory/part/createPart";
		}

		part.setModifiedDate(new Date());
		Long id = partService.addPart(part);

		model.addAttribute("message",
				"Part created successfully! For your reference, the PartID is "
						+ id);
		// provide a new Part object - alternatively clear all fields
		model.addAttribute("part", new Part());

		return "inventory/part/createPart";
	}

	@RequestMapping("search.html")
	public String search(@ModelAttribute("part") Part part,
			@RequestParam("rowsPerPage") String rowsPerPage, ModelMap model,
			BindingResult result, HttpSession session) {

		int rows = Integer.parseInt(rowsPerPage);
		session.setAttribute("rowsPerPage", rows);

		List<Part> list = partService.findPartLike(part, rows, 1);
		model.put("partList", list);

		Long count = partService.getCount(part);

		StringBuilder query = new StringBuilder();
		query.append("name=" + ((part.getName() == null) ? "" : part.getName()));
		query.append("&sku=" + ((part.getSku() == null) ? "" : part.getSku()));
		query.append("&manufacturer=" + part.getManufacturer().getId());
		query.append("&modelno="
				+ ((part.getModelNo() == null) ? "" : part.getModelNo()));
		query.append("&partno="
				+ ((part.getPartNo() == null) ? "" : part.getPartNo()));
		query.append("&description="
				+ ((part.getDescription() == null) ? "" : part.getDescription()));
		query.append("&quantity="
				+ ((part.getQuantity() == null) ? "" : part.getQuantity()));
		// query.append("&contactnumber=" + part.getModifiedDate());

		System.err.println("query: " + query);
		System.err.println("count: " + count);
		System.err.println("rows: " + rows);
		System.err.println("maxpage: "
				+ (((long) count / rows) == 0 ? 1 : (long) Math
						.ceil((double) count / rows)));

		model.put("query", query.toString());
		model.put("page", 1);
		model.put(
				"maxpage",
				(((long) count / rows) == 0 ? 1 : (long) Math
						.ceil((double) count / rows)));

		return "inventory/part/searchPart";
	}

	@RequestMapping("/doPaging.html")
	public String navigate(@RequestParam("name") String name,
			@RequestParam("manufacturer") String manufacturer,
			@RequestParam("sku") String sku,
			@RequestParam("modelno") String modelNo,
			@RequestParam("partno") String partNo,
			@RequestParam("description") String desc,
			@RequestParam("quantity") String quantity,
			@RequestParam("page") String page, ModelMap model,
			HttpSession session, @ModelAttribute Part modelType) {

		System.err.println("=====Paging+++++");
		int rows = (Integer) session.getAttribute("rowsPerPage");

		Part part = new Part();
		part.setName(name);
		part.setSku(sku);
		part.setModelNo(modelNo);
		part.setPartNo(partNo);
		part.setDescription(desc);

		if (quantity != null && !quantity.equals(""))
			part.setQuantity(Long.parseLong(quantity));

		Manufacturer manuf = manufService
				.findById(Long.parseLong(manufacturer));
		part.setManufacturer(manuf);

		List<Part> list = partService.findPartLike(part, rows,
				Integer.parseInt(page));
		model.put("partList", list);
		Long count = partService.getCount(part);

		StringBuilder query = new StringBuilder();
		query.append("name=" + ((part.getName() == null) ? "" : part.getName()));
		query.append("&sku=" + ((part.getSku() == null) ? "" : part.getSku()));
		query.append("&manufacturer=" + part.getManufacturer().getId());
		query.append("&modelno="
				+ ((part.getModelNo() == null) ? "" : part.getModelNo()));
		query.append("&partno="
				+ ((part.getPartNo() == null) ? "" : part.getPartNo()));
		query.append("&description="
				+ ((part.getDescription() == null) ? "" : part.getDescription()));
		query.append("&quantity="
				+ ((part.getQuantity() == null) ? "" : part.getQuantity()));
		// query.append("&contactnumber=" + part.getModifiedDate());

		model.put("query", query.toString());
		model.put("page", page);
		model.put(
				"maxpage",
				(((long) count / rows) == 0 ? 1 : (long) Math
						.ceil((double) count / rows)));

		return "inventory/part/searchPart";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.err.println("++++++++++BINDER CALLED+++++++++++");
		binder.registerCustomEditor(List.class, "manufacturer",
				new CustomCollectionEditor(List.class) {

					private Long id;

					@Override
					protected Object convertElement(Object element) {
						System.err
								.println("************Conver Element called!!!**********");

						if (element instanceof String) {

							// From the JSP 'element' will be a String
							try {
								id = Long.parseLong((String) element);
							} catch (NumberFormatException e) {
								System.out.println("Element was "
										+ ((String) element));
								e.printStackTrace();
							}
						} else if (element instanceof Long) {
							// From the database 'element' will be a Long
							id = (Long) element;
						}

						return id != null ? manufService.findById(id) : null;
					}

				});
	}

}
