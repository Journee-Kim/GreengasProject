package com.carbonjava.tumblerMileageProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Entity @Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbl_user")
public class UserVO {
	
	@Id
	String userId;
	String userPw;
	String userName;
	String address;
	int echoMileage;

}
