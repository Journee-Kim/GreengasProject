package com.carbonjava.tumblerMileageProject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.carbonjava.tumblerMileageProject.model.TumblerVO;
import com.carbonjava.tumblerMileageProject.model.UserVO;

public interface TumblerRepository extends CrudRepository<TumblerVO, Long>{

	public List<TumblerVO> findByUser(UserVO user);

	@Query("select useCnt from TumblerVO where tumblerId=?1")
	public int selectUseCntById(Long tumblerid);
}
