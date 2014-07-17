package com.marsapps.iautomech.web.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/part")
@SessionAttributes("manufacturerList")
public class PartController {

	@Autowired
	private PartService partService;

	@Autowired
	private ManufacturerService manufService;

	@RequestMapping(value = { "/", "/home" })
	public String showHomePage() {
		return "part/home";
	}

	@RequestMapping("searchForm.html")
	public String showSearchForm(Model model) {
		model.addAttribute("part", new Part());		
		model.addAttribute("manufacturerList", manufService.getAllManufacturers());
		return "part/searchPart";
	}

	@RequestMapping("/search.html")
	public String search(@ModelAttribute Part part,
			BindingResult result, ModelMap model, HttpServletRequest request) {
		System.err.println("READY!!!!!!!!!!!!!!");
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();

			for (FieldError error : errors) {
				System.err.println("FIELD ++++++++++++++++: "
						+ error.getField());
			}
			return "part/searchPart";
		}

		List<Part> list = partService.findPartLike(part);
		model.put("partList", list);

		return "part/searchPart";
	}

	@RequestMapping("/createForm.html")
	public ModelAndView showCreatePartForm() {
		ModelAndView mav = new ModelAndView("part/createPart");

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
			return "part/createPart";
		}

		part.setModifiedDate(new Date());
		Long id = partService.addPart(part);

		model.addAttribute("message",
				"Part created successfully! It's ID for you reference is " + id);
		// provide a new Part object - alternatively clear all fields
		model.addAttribute("part", new Part());

		return "part/createPart";
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
