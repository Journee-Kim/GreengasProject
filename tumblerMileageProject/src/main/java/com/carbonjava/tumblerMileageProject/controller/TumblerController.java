package com.carbonjava.tumblerMileageProject.controller;

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
	public void tumblerlist(Model model) {
		String userid = "mem1";
		UserVO user = UserVO.builder().userId(userid).build();
		
		model.addAttribute("tumblerlist", service.selectByUser(user));
		
	}
	
	@GetMapping("tumblerSelect")
	public void tumblerSelect(Model model) {
		String userid = "mem1";
		UserVO user = UserVO.builder().userId(userid).build();
		model.addAttribute("tumblerlist", service.selectByUser(user));
	}
	
   @GetMapping("createQRCode") //해당하는 ID에 새로운 QR코드 생성
   public void createQRCode(Model model) { // (이 메소드를 텀블러 등록할 때 추가해야 합니다!!!)
      service.insertQR(643L);
      service.insertQR(644L);
      service.insertQR(645L);
      service.insertQR(646L);
      
   }
   

   @GetMapping("selectQR") //해당하는 Id의 QR코드를 String으로 리턴
   public void selectQR(Model model) {
      Optional<TumblerVO> tumbler = service.findByTumblerId(643L);
      String QR = tumbler.get().getTumblerQR();
      //log.info(QR);
      model.addAttribute("QR", QR);

   }

}
