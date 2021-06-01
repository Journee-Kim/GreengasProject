package com.carbonjava.tumblerMileageProject.persistence;

import org.springframework.data.repository.CrudRepository;

import com.carbonjava.tumblerMileageProject.model.UserVO;

public interface UserRepository extends CrudRepository<UserVO, String>{

}
