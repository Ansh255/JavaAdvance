package com.SCM.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SCM.model.userVO;
@Repository
@Transactional
public interface UserRepo extends JpaRepository<userVO, Integer>{
	@Query("select u from userVO u where u.email = :email")
	public userVO getUsername(@Param("email") String email);
}
