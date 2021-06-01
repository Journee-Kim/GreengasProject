package com.carbonjava.tumblerMileageProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carbonjava.tumblerMileageProject.service.TumblerService;



@Controller
public class MainController {

	@Autowired
	TumblerService service;
	
	@RequestMapping("/main")
	public void mainpage(Model model) {
		model.addAttribute("usecnt", service.selectUseCntById(643L));
		
		System.out.println("check");
	}
}
