package com.carbonjava.tumblerMileageProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.carbonjava.tumblerMileageProject.model.TumblerVO;
import com.carbonjava.tumblerMileageProject.model.UserRoleEnumType;
import com.carbonjava.tumblerMileageProject.model.UserVO;
import com.carbonjava.tumblerMileageProject.persistence.TumblerRepository;
import com.carbonjava.tumblerMileageProject.persistence.UserRepository;
import com.carbonjava.tumblerMileageProject.service.UserService;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class TumblerTest {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService service;
	
	@Autowired
	TumblerRepository tumblerRepo;
	
	// @Test
	public void findByUser() {
		String userid = "mem1";
		UserVO user = UserVO.builder().userId(userid).build();
		
		tumblerRepo.findByUser(user).forEach(tumbler -> {
			log.info(tumbler.toString());
		});
	}
	
	@Test
	public void insertQR() {
		tumblerRepo.findById(1001L).ifPresent(tumbler -> {
			String tumblerQR = "http://chart.googleapis.com/chart?cht=qr&chs=500x500&chl=" // 여기에 넘어갈 페이지명 넣으면 됨
					+ tumbler.getTumblerId();
			tumbler.setTumblerQR(tumblerQR);
			System.out.println("새로 생성된 QR: " + tumbler.getTumblerQR());
			tumblerRepo.save(tumbler);
		});
		tumblerRepo.findById(1002L).ifPresent(tumbler -> {
			String tumblerQR = "http://chart.googleapis.com/chart?cht=qr&chs=500x500&chl=" // 여기에 넘어갈 페이지명 넣으면 됨
					+ tumbler.getTumblerId();
			tumbler.setTumblerQR(tumblerQR);
			System.out.println("새로 생성된 QR: " + tumbler.getTumblerQR());
			tumblerRepo.save(tumbler);
		});
	}
	
	//@Test
	public void insertTumbler() {
		String userid = "mem2";
		UserVO user = UserVO.builder().userId(userid).build();
// 흰		
//		.tumblerImg("https://www.wellbow.co.kr/wp-content/uploads/2018/11/kinto_white_17oz_01.png")
//분
		//		.tumblerImg("http://img.danawa.com/prod_img/500000/593/450/img/12450593_1.jpg?shrink=360:360&_v=20201014124129")
// 까망
		//		.tumblerImg("http://img.danawa.com/prod_img/500000/430/298/img/6298430_1.jpg?shrink=360:360&_v=20191029163609")
//초록
		//		.tumblerImg("https://image.msscdn.net/images/goods_img/20200428/1426512/1426512_1_500.jpg")
		TumblerVO tumbler = TumblerVO.builder()
				.tumblerName("초록")
				.tumblerImg("https://image.msscdn.net/images/goods_img/20200428/1426512/1426512_1_500.jpg")
				.user(user)
				.useCnt(0)
				.build();
		tumblerRepo.save(tumbler);
	}
	
	// @Test
	public void selectUser() {
		userRepo.findAll().forEach(user -> {
			log.info(user.toString());
		});
	}
	
	// @Test
	public void insertUser() {
		UserVO user = UserVO.builder()
				.userId("mem2")
				.userPw("1234")
				.userName("탄소자바")
				.address("서울특별시 관악구")
				.userRole(UserRoleEnumType.USER)
				.echoMileage(150)
				.build();
		service.joinUser(user);
	}
}
