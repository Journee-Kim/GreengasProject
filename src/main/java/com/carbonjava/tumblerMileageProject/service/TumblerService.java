package com.carbonjava.tumblerMileageProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbonjava.tumblerMileageProject.model.TumblerVO;
import com.carbonjava.tumblerMileageProject.model.UserVO;
import com.carbonjava.tumblerMileageProject.persistence.TumblerRepository;

import lombok.extern.java.Log;

@Log
@Service
public class TumblerService {

	@Autowired
	TumblerRepository repo;
	
	public int selectUseCntById(Long tumblerid) {
		return repo.selectUseCntById(tumblerid); 
	}
	
	public List<TumblerVO> selectByUser(UserVO user){
		return repo.findByUser(user);
	}
	
	//텀블러 테이블에 QR코드를 생성해서 입력하는 메소드
   public void insertQR(Long tumblerId) {
      repo.findById(tumblerId).ifPresent(tumbler->{
         String tumblerQR = "http://chart.googleapis.com/chart?cht=qr&chs=500x500&chl=" //여기에 넘어갈 페이지명 넣으면 됨
                        +tumbler.getTumblerId();
         tumbler.setTumblerQR(tumblerQR);
         System.out.println("새로 생성된 QR: "+tumbler.getTumblerQR());
         repo.save(tumbler);
      });
      
   }
   
   public Optional<TumblerVO> findByTumblerId(long tumblerId){
      return repo.findById(tumblerId);
      
   }

}
