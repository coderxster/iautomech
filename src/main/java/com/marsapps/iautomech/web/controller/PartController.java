package com.marsapps.iautomech.web.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.domain.Part;
import com.marsapps.iautomech.service.ManufacturerService;
import com.marsapps.iautomech.service.PartService;
import com.marsapps.iautomech.web.converter.ManufacturerPropertyEditor;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private PartService partService;
	
	@Autowired
	private ManufacturerService manufService;

	@RequestMapping("/home")
	public String showHomePage() {
		return "part/home";
	}

	@RequestMapping("searchForm.html")
	public String showSearchForm(Model model) {
		model.addAttribute("part", new Part());
		return "part/searchPart";
	}

	@RequestMapping("/search.html")
	public String search(@ModelAttribute Part part, ModelMap model,
			HttpServletRequest request, BindingResult result) {

		if (result.hasErrors()) {
			System.err.println("ERRORs FOUNF +++++++++++++::::");
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError e : errors) {
				System.err.println("ERROR++++++++++:::: "
						+ e.getDefaultMessage());
			}

		}

		System.err.println("?????????11  "
				+ ((Part) model.get("part")).getModifiedDate());
	
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
	
	@RequestMapping("create")
	public ModelAndView create(@ModelAttribute Part part, BindingResult result) {
		
		if(result.hasErrors())
			System.err.println("BINDING ERROR WERE ENCOUNTERED!!!!!!");
		
		ModelAndView mav = new ModelAndView("part/createPart");
		
		part.setModifiedDate(new Date());
		Long id = partService.addPart(part);
		
		mav.addObject("", (id != null) ? "Part created successfully!" : "Part was not create. Please check with administrator");
		
		return mav;
	}
	
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat(
//				"dd/MM/yyyy hh:mm:ss");
//
//		ManufacturerPropertyEditor editor = new ManufacturerPropertyEditor();
//		System.err.println("BINDER CALLED++++++++++++++++++++++++");
//		binder.registerCustomEditor(Manufacturer.class, editor);
//	}

}