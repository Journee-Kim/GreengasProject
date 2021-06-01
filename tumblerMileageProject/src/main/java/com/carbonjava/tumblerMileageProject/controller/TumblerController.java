package com.carbonjava.tumblerMileageProject.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carbonjava.tumblerMileageProject.model.TumblerVO;
import com.carbonjava.tumblerMileageProject.model.UserVO;
import com.carbonjava.tumblerMileageProject.service.TumblerService;

import lombok.extern.java.Log;

@Log
@Controller
public class TumblerController {

	@Autowired
	TumblerService service;
	
	@GetMapping("tumblerlist")
	public void tumblerlist(Model model, Principal principal) {
		String userid = principal.getName();
		log.info(userid);
		UserVO user = UserVO.builder().userId(userid).build();
		
		model.addAttribute("tumblerlist", service.selectByUser(user));
		
	}
	
	@GetMapping("tumblerSelect")
	public void tumblerSelect(Model model, Principal principal) {
		String userid = principal.getName();
		UserVO user = UserVO.builder().userId(userid).build();
		model.addAttribute("tumblerlist", service.selectByUser(user));
	}

}
