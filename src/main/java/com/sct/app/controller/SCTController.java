package com.sct.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sct.app.user.services.UserService;

@Controller
@Configuration
@ComponentScan({ "com.sct.app" })
public class SCTController {

	  @Autowired UserService service;
	 
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String loginPage(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = { "/internal" }, method = { RequestMethod.GET })
	public String redirectPage(ModelMap model) {
		return "redirect:/";
	}
	
	
}