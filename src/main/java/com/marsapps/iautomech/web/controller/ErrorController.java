package com.marsapps.iautomech.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/error.jsp")
	public String _404error() {
		return "error/error";
	}
}
