package com.carbonjava.tumblerMileageProject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carbonjava.tumblerMileageProject.model.UserVO;
import com.carbonjava.tumblerMileageProject.persistence.UserRepository;
import com.carbonjava.tumblerMileageProject.security.SecurityUser;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder; // security config에서 Bean생성
	
	// 회원가입
	@Transactional
	public UserVO joinUser(UserVO user) {
		// 비밀번호 암호화...암호화되지않으면 로그인되지않는다.
		user.setUserPw(passwordEncoder.encode(user.getUserPw()));
		// member.setMrole(MemberRoleEnumType.USER);
		System.out.println(passwordEncoder.encode(user.getUserPw()));
		return userRepository.save(user);
	}
	
	// 반드시 구현해야함
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		// memberdto -> securityUser
		// filter : 조건에 맞는것만 선택
		// map : 변형한다.
		UserDetails user = userRepository.findById(userid)
				.filter(m -> m != null).map(m -> new SecurityUser(m)).get();
		return user;
	}
}
