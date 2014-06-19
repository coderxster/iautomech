package com.marsapps.iautomech.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home", "/index.html"})
	public String showHomePage() {
		return "home";
	}
}
