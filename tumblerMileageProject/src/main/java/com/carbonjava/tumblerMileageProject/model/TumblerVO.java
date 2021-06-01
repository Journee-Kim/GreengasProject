package com.carbonjava.tumblerMileageProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_tumbler")
public class TumblerVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long tumblerId;
	String tumblerName;
	String tumblerImg;
	int useCnt;
	String tumblerQR;
	
	@ManyToOne
	UserVO user;	// user_user_id 컬럼
}
