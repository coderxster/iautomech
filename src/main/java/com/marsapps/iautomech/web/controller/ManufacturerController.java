package com.marsapps.iautomech.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.marsapps.iautomech.domain.Manufacturer;
import com.marsapps.iautomech.service.ManufacturerService;

@Controller
@RequestMapping("/manufacturer")
@SessionAttributes("manufacturer")
public class ManufacturerController {

	@Autowired
	private ManufacturerService service;
	
	@RequestMapping("/home.html")
	public String showHomePage() {
		return "manufacturer/home";
	}
	
	
	@RequestMapping("/listAll.html")
	public String listManufacturers(Model model, HttpSession session) {
		List<Manufacturer> list = service.getAllManufacturers();
		session.setAttribute("manufList", list);
		return "manufacturer/home";
	}
	
}
