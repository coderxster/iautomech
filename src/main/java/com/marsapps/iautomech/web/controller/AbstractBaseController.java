package com.marsapps.iautomech.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marsapps.iautomech.domain.Manufacturer;

@Controller
public abstract class AbstractBaseController<T> {

//	@RequestMapping("/doPaging.html")
//	public T navigate(@RequestParam("name") String name,
//			@RequestParam("contactname") String contactName,
//			@RequestParam("contactnumber") String contactNumber,
//			@RequestParam("page") String page, ModelMap model,
//			HttpSession session, @ModelAttribute T entityType) {
//		
//		T obj = (T) session.getAttribute("");

//		session.getAttribute()
//		System.err.println("=====LETS 11111 SEE+++ ");
//		try {
//			System.err.println("=====LETS SEE+++: "
//					+ .getClass().getField("contactName")
//							.get(modelType.getClass().newInstance()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	// public abstract String showHomePage();

	// public showCreateForm(ModelMap model) {
	// return "manufacturer/createManufacturer";
	// }
	//
	// public abstract String create(@ModelAttribute("manufacturer") T entity,
	// ModelMap model);
	//
	//
	// @RequestMapping("/delete/{id}")
	// public String delete(@PathVariable("id") String id, ModelMap model) {
	//
	//
	// @RequestMapping(value = "/searchForm.html", method = RequestMethod.GET)
	// public String showSearchForm(ModelMap model) {
	//
	//
	// @RequestMapping(value = "/search.html", method = RequestMethod.POST)
	// public String search(@ModelAttribute("manufacturer") Manufacturer manuf,
	//
	//
	// @RequestMapping("/listAll.html")
	// public String listManufacturers(Model model, HttpSession session) {
	//
	// @RequestMapping("/doPaging.html")
	// public String navigate(@RequestParam("name") String name,
	// @RequestParam("contactname") String contactName,
	// @RequestParam("contactnumber") String contactNumber,
	// @RequestParam("page") String page, ModelMap model, HttpSession session)
	//
	// @RequestMapping("/delete.html")
	// public String deleteManufacturers(ModelMap model, HttpSession session,
	//
	// public String deleteManufacturers(ModelMap model, HttpSession session) {
	//
	//
}
